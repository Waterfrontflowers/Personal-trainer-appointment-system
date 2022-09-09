package com.nchu.ptas.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.ptas.object.JsonReturn;

/**
 * @author Ginger
 * @date 2022-09-09
 */
public class Json {
    public static String entity2Json(Object entity){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String jsonReturn(int code,String msg,Object object){
        return new JsonReturn(code,msg,Json.entity2Json(object)).toString();
    }
}
