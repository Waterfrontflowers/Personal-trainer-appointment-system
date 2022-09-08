package com.nchu.ptas.controller;

import com.nchu.ptas.entity.User;
import com.nchu.ptas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@RestController
@RequestMapping("/ptas")
public class UserController {

    @Autowired
    UserService userService;

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
}
