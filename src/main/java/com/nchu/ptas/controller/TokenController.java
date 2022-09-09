package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Token;
import com.nchu.ptas.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ginger
 * @date 2022-09-09
 */
@RestController
@RequestMapping("/ptas")
public class TokenController {
    @Autowired
    TokenService tokenService;

   /* @RequestMapping("/token")
    public String tokenCheck(@RequestBody Token token){
        return tokenService.tokenCheck(token);
    }*/
}
