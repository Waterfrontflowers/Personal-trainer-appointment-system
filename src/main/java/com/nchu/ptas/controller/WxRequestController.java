package com.nchu.ptas.controller;

import com.nchu.ptas.service.WxRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ginger
 * @date 2022-09-08
 */
public class WxRequestController {
    @GetMapping("/wx/onLogin")
    @ResponseBody
    public String onLogin(HttpServletRequest httpServletRequest){
        return WxRequestService.onLogin(httpServletRequest);
    }

}
