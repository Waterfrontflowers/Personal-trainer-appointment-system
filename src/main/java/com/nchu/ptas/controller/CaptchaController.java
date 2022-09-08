package com.nchu.ptas.controller;


import com.nchu.ptas.object.Captcha;
import com.nchu.ptas.utils.ReCaptcha;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ginger
 * @date 2022-09-02
 */
@RestController
public class CaptchaController {
    @RequestMapping("/captcha")
    @ResponseBody
    public String check(@RequestBody Captcha captcha) {
        return ReCaptcha.v3(captcha);
    }
}
