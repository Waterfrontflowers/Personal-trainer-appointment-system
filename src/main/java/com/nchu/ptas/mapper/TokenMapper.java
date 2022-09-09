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

    int insertWithOpenIdAndToken(String openId,String token);

    List<Token> findByOpenId(String openId);

    int updateWithOpenIdAndToken(String openId,String tokenOld,String tokenNew);

    List<Token> findByOpenIdAndToken(String openId,String token);


}
