package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 在视图中以状态查找
     * @param status 售卖状态
     * @return 课程列表
     */
    List<Map<String,Object>> findOnSellWithViewByStatus(int status);

    /**
     * 查找有课的教练
     * @return coach_id 教练id number课程数量
     */
    List<Map<String,Integer>> whoHasCourse();

    /**
     * 以教练id查找课程
     * @param coachId 教练id
     * @return 课程列表
     */
    List<Course> findByCoachId(int coachId);

    /**
     * 查找教练信息
     * @param coachId 教练id
     * @return 教练信息
     */
    List<Map<String,Object>> findCoachById(List<Integer> coachId);
}
