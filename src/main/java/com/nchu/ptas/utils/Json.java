package com.nchu.ptas.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.ptas.object.JsonReturn;
import org.springframework.lang.Nullable;

/**
 * @author Ginger
 * @date 2022-09-09
 */
public class Json {

    /**
     *
     * @param entity 需要被转换为json的对象
     * @return json 字符串
     */
    public static String entity2Json(Object entity){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param code 状态码
     * @param msg 状态消息（状态码解释）
     * @param object 需要返回数据的
     * @return 完整的带数据的json返回字符串
     */
    public static String jsonReturn(int code,String msg,@Nullable Object object){
        return new JsonReturn(code,msg,Json.entity2Json(object)).toString();
    }

    /**
     *
     * @param code 状态码
     * @param msg 状态消息（状态码解释）
     * @return 无数据返回的json字符串
     */
    public static String jsonReturn(int code,String msg){
        return new JsonReturn(code,msg,null).toString();
    }

}
