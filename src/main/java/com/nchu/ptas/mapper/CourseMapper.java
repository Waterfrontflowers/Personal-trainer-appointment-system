package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@Mapper
public interface CourseMapper {
    /**
     * 以课程状态来查找
     * @param status 课程状态.1-在售 2-下架 3-删除
     * @return 课程列表
     */
    List<Course> findByStatus(int status);

    /**
     * 以课程编号查找
     * @param id 课程编号
     * @return 课程列表
     */
    List<Course> findOnSellById(List<Integer> id);
}
