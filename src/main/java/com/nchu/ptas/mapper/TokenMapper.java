package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.Token;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Mapper
public interface TokenMapper {
    /**
     * 用于登录数据插入
     * @param openId 用户的openId (微信小程序个人识别码）
     * @param token 服务器认证的token代码
     * @return 1成功 0失败
     */
    int insertWithOpenIdAndToken(String openId,String token);

    /**
     * 用于查找token数量，同时方便找到最久远认证的token
     * @param openId 用户的openId(微信小程序个人识别码）
     * @return token列表，按时间升序
     */
    List<Token> findByOpenId(String openId);

    /**
     * 用于更新token认证代码
     * @param openId 用户的openId(微信小程序个人识别码）
     * @param tokenOld 用户旧的认证代码
     * @param tokenNew 用户新的认证代码
     * @return 1成功 0失败
     */
    int updateWithOpenIdAndToken(String openId,String tokenOld,String tokenNew);

    /**
     * 用于核对openId和认证代码是否合法
     * @param openId 用户的openId(微信小程序个人识别码）
     * @param token 认证代码
     * @return 查找结果，能查到即合法
     */
    List<Token> findByOpenIdAndToken(String openId,String token);


}
