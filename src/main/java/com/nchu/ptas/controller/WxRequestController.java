package com.nchu.ptas.controller;

import com.nchu.ptas.service.WxRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ginger
 * @date 2022-09-08
 *
 * 该控制层仅用于需要与微信服务器交互的 api 接口
 */
public class WxRequestController {
    @GetMapping("/wx/onLogin")
    @ResponseBody
    public String onLogin(HttpServletRequest httpServletRequest){
        return WxRequestService.onLogin(httpServletRequest);
    }

}
