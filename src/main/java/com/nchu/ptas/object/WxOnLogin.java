package com.nchu.ptas.object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Getter
@Setter
public class WxOnLogin {
    private int errcode;
    private String errmsg;
    private String session_key;
    private String openid;

    public static WxOnLogin deserialization(String json){
        ObjectMapper mapper = new ObjectMapper();
        WxOnLogin wxOnLogin;
        try {
            wxOnLogin = mapper.readValue(json, WxOnLogin.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return wxOnLogin;

    }
}
