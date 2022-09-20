package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Token;
import com.nchu.ptas.service.UserService;
import com.nchu.ptas.service.WxRequestService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ginger
 * @date 2022-09-08
 *
 * 该控制层仅用于需要与微信服务器交互的 api 接口
 */
@RestController
@RequestMapping("/ptas")
public class WxRequestController {
    @Autowired
    WxRequestService wxRequestService;

    @Autowired
    UserService userService;

    @GetMapping("/wx/onLogin")
    @ResponseBody
    public Json onLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Token token = wxRequestService.onLogin(httpServletRequest);
        if(token.getOpenId()!= null && token.getToken() != null) {
            Cookie openIdCookie = new Cookie("openId",token.getOpenId());
            Cookie tokenCookie = new Cookie("token",token.getToken());
            httpServletResponse.addCookie(openIdCookie);
            httpServletResponse.addCookie(tokenCookie);
            return Json.response(200, "success",userService.userInfo(token.getOpenId()));
        }
        else {
            return Json.response(400,"not found");
        }
    }

}
