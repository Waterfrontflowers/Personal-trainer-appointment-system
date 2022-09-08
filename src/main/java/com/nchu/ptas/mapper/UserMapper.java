package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Mapper
public interface UserMapper {
    List<User> listAll();

    int insertWithUserNameAndPasswordAndPhone(String userName,String password,String phone);
    int insertWithOpenId(String openId);

    List<User> findByOpenId(String openId);
}
