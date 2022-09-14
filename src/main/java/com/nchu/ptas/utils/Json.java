package com.nchu.ptas.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-09
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Json {

    private int code;
    private String msg;
    private Object data;

    /**
     *
     * @param entity 需要被转换为json的对象
     * @return json 字符串
     */
    public static String entity2Json(Object entity){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化，会忽视对象中不存在的数据
     * @param map map数据
     * @param myClass 反序列化的类
     * @return 反序列化后的对象
     */
    public static Object deserialization(Map<String,Object> map,Class<?> myClass) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object object;
        try {
            String json = mapper.writeValueAsString(map);
            object = mapper.readValue(json, myClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    /**
     * 构建返回数据体
     * @param code 状态码
     * @param msg 状态消息（状态码解释）
     * @param object 需要返回数据的
     * @return 完整的带数据的json对象，返回时会由Jackson自动序列化
     */
    public static Json response(int code,String msg,@Nullable Object object){
        return new Json(code,msg,object);
    }

    /**
     * 构建无数据返回对象体
     * @param code 状态码
     * @param msg 状态消息（状态码解释）
     * @return 无数据返回的json对象，返回时会由Jackson自动序列化
     */
    public static Json response(int code,String msg){
        return new Json(code,msg,null);
    }

}
