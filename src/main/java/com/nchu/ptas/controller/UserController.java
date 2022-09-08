package com.nchu.ptas.controller;

import com.nchu.ptas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String user(){
        return userService.getAll();
    }
}
