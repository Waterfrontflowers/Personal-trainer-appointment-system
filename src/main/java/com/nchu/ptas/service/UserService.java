package com.nchu.ptas.service;

import com.nchu.ptas.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String getAll(){
        return userMapper.listAll().toString();
    }

}
