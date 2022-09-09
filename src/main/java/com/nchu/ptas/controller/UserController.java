package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Token;
import com.nchu.ptas.entity.User;
import com.nchu.ptas.object.JsonReturn;
import com.nchu.ptas.service.TokenService;
import com.nchu.ptas.service.UserService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String rename(@RequestBody Map<String,String> map){
        Token token = tokenService.deserialization(map);
        User user = userService.deserialization(map);
        if(tokenService.tokenCheck(token)){
            if(userService.rename(user) == 1){
                return Json.jsonReturn(200,"success",user);
            }
        }
        else{
            return Json.jsonReturn(100,"鉴权错误",null);
        }
        return Json.jsonReturn(500,"error",null);

    }
}
