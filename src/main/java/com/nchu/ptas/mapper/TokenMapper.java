package com.nchu.ptas.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Mapper
public interface TokenMapper {

    int insertWithOpenIdAndToken(String openId,String token);
}
