package com.nchu.ptas.service;

import com.nchu.ptas.utils.HttpSendUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Service
@Transactional
public class WxRequestService {
    public static String onLogin(HttpServletRequest httpServletRequest){
        String code = httpServletRequest.getParameter("code");
        String appId = System.getenv("wx_appId");
        String appSecret = System.getenv("wx_appSecret");
        String param = "appid="+appId+"&secret="
                + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        String json = HttpSendUtil.instance().sendGet("https://api.weixin.qq.com/sns/jscode2session?"+param,"UTF-8");
        System.out.println(json);
        return json;
    }
}
