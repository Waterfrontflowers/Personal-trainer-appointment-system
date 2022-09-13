package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-13
 */
@Mapper
public interface ImageMapper {
    /**
     * 查找所有正在使用的轮播图
     * @return 轮播图对象
     */
    List<Image> findByUsedSlideshow();
}
