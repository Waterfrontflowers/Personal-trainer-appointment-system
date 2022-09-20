package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Token;
import com.nchu.ptas.entity.User;
import com.nchu.ptas.service.TokenService;
import com.nchu.ptas.service.UserService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@RestController
@RequestMapping("/ptas")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @RequestMapping("/user")
    public List<User> user(){
        return userService.getAll();
    }

    @RequestMapping("/insert")
    public int insert(HttpServletRequest httpServletRequest){
        User user = new User();
        user.setUserName(httpServletRequest.getParameter("userName"));
        user.setPassword(httpServletRequest.getParameter("password"));
        user.setPhone(httpServletRequest.getParameter("phone"));
        return userService.insert(user);
    }

    @PostMapping("/rename")
    public Json rename(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token,@RequestBody User user){
        if(user.getUserName() == null || "".equals( user.getUserName())){
            return Json.response(106,"缺少参数");
        }
        if(tokenService.tokenCheck(openId, token)){
            user.setOpenId(openId);
            if(userService.rename(user) == 1){
                return Json.response(200,"success",user);
            }
        }
        else{
            return Json.response(100,"鉴权错误");
        }
        return Json.response(500,"error");

    }


    @GetMapping("/userInfo")
    @ResponseBody
    public Json userInfo(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token){
        if(tokenService.tokenCheck(openId,token)){
            return Json.response(200,"success",userService.userInfo(openId));
        }
        else {
            return Json.response(100,"鉴权错误");
        }
    }
}
