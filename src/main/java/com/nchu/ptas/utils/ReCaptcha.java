package com.nchu.ptas.utils;


import com.nchu.ptas.object.Captcha;

/**
 * @author Ginger
 * @date 2022-08-31
 */
public class ReCaptcha {
    public static String v3(Captcha captcha) {
        //String checkCode = request.getParameter("token");
        //String checkCode = captcha.getCaptcha();
        String secret = "6LcoKMAhAAAAAEuw9yM2J__ET10FSfJGwVWzA-z7";
        String param = "secret="+secret+"&response="
                + captcha.getCaptcha();
        String json = HttpSendUtil.instance().sendPost("https://www.recaptcha.net/recaptcha/api/siteverify", param, "UTF-8");
        return json;
    }
}
