package com.nchu.ptas.service;

import com.nchu.ptas.entity.User;
import com.nchu.ptas.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
