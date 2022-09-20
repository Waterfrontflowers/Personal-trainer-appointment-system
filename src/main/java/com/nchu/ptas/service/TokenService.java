package com.nchu.ptas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.ptas.entity.Token;
import com.nchu.ptas.mapper.TokenMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-09
 */
@Service
@Transactional
public class TokenService {
    @Autowired
    TokenMapper tokenMapper;

    public boolean tokenCheck(String openId,String token){
        return openId != null && token != null && tokenMapper.findByOpenIdAndToken(openId, token).size() != 0;
    }

    public Token deserialization(Map map) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Token token;
        try {
            String json = mapper.writeValueAsString(map);
            token = mapper.readValue(json, Token.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return token;
    }

}
