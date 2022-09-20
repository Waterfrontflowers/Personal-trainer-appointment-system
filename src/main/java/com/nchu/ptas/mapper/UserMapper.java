package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Mapper
public interface UserMapper {
    /**
     * 查找所有用户
     * @return 用户列表
     */
    List<User> listAll();

    /**
     * 暂时废弃的新用户插入
     * @param userName 用户昵称
     * @param password 密码
     * @param phone 手机号
     * @return 1成功 0失败
     */
    int insertWithUserNameAndPasswordAndPhone(String userName,String password,String phone);

    /**
     * 新用户数据插入
     * @param openId 微信小程序个人识别码
     * @return 1成功 0失败
     */
    int insertWithOpenId(String openId);

    /**
     * 单一用户数据查找
     * @param openId 微信小程序个人识别码
     * @return 用户数据
     */
    List<User> findByOpenId(String openId);

    /**
     * 更新用户名
     * @param openId 微信小程序个人识别码
     * @param userName 用户名
     * @return 1成功 0失败
     */
    int updateUserNameWithOpenId(String openId,String userName);

    /**
     * 更新图片信息
     * @param userId 用户编码
     * @param imageId 图片编码
     */
    void updateImage(int userId,int imageId);
}
