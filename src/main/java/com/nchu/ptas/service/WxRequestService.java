package com.nchu.ptas.service;

import com.nchu.ptas.entity.Token;
import com.nchu.ptas.mapper.TokenMapper;
import com.nchu.ptas.mapper.UserMapper;
import com.nchu.ptas.object.WxOnLogin;
import com.nchu.ptas.utils.HttpSendUtil;
import com.nchu.ptas.utils.SHAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Service
@Transactional
public class WxRequestService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenMapper tokenMapper;

    private final int TOKEN_MAX = 3;
    /**
     *
     * @param httpServletRequest 前端数据
     * @return 微信api返回值
     *
     * 注：appId 与 appSecret 安全起见记录在环境变量中，分别为 wx_appId 与 wx_appSecret
     */
    public Token onLogin(HttpServletRequest httpServletRequest){
        String code = httpServletRequest.getParameter("code");
        String appId = System.getenv("wx_appId");
        String appSecret = System.getenv("wx_appSecret");
        //System.out.println(appSecret);
        String param = "appid="+appId+"&secret="
                + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        String json = HttpSendUtil.instance().sendGet("https://api.weixin.qq.com/sns/jscode2session?"+param,"UTF-8");
        System.out.println(json);
        WxOnLogin wxOnLogin = WxOnLogin.deserialization(json);
        Token token = new Token();
        if(wxOnLogin.getOpenid()!=null){
            token.setOpenId(wxOnLogin.getOpenid());

            if(userMapper.findByOpenId(token.getOpenId()).size() == 0){
                userMapper.insertWithOpenId(token.getOpenId());
            }

            token.setToken(new SHAUtil().SHA512(token.getOpenId() + new Date()));
            if(tokenMapper.findByOpenId(token.getOpenId()).size() <= TOKEN_MAX) {
                tokenMapper.insertWithOpenIdAndToken(token.getOpenId(), token.getToken());
            }
            else{
                List<Token> tokens = tokenMapper.findByOpenId(token.getOpenId());
                tokenMapper.updateWithOpenIdAndToken(token.getOpenId(),tokens.get(0).getToken(),token.getToken());
            }
        }
        return token;
    }


}
