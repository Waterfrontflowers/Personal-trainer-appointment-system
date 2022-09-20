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

    /**
     * 保存图片信息
     * @param image 图片对象
     */
    void save(Image image);

    /**
     * 通过url查找图片编号
     * @param url 图片地址
     * @return 图片对象
     */
    List<Image> findByUrl(String url);

    /**
     * 查找图片信息
     * @param id 图片编号
     * @return 图片列表
     */
    List<Image> findById(int id);

    /**
     * 图片不再使用
     * @param pic_id 图片编号
     */
    void doNotUsed(int pic_id);
}
