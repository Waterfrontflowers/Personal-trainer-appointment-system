package com.nchu.ptas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.ptas.service.TokenService;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Getter
@Setter
public class Token {
    @JsonIgnore
    private int id;
    private String openId;
    private String token;
    @JsonIgnore
    private Date loginTime;

    public Token(){

    }

    public Token(String openId,String token){
        this.openId = openId;
        this.token = token;
    }

}
