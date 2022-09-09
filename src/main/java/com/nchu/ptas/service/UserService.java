package com.nchu.ptas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.ptas.entity.User;
import com.nchu.ptas.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.listAll();
    }

    public int insert(User user){
        return userMapper.insertWithUserNameAndPasswordAndPhone(user.getUserName(),user.getPassword(),user.getPhone());
    }

    public int rename(User user){
        return userMapper.updateUserNameWithOpenId(user.getOpenId(),user.getUserName());
    }

    public User userInfo(String openId){
        return userMapper.findByOpenId(openId).get(0);
    }

    public User deserialization(Map map) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        User user;
        try {
            String json = mapper.writeValueAsString(map);
            user = mapper.readValue(json, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
