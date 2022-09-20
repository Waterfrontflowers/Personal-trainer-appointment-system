package com.nchu.ptas.service;

import com.nchu.ptas.entity.Course;
import com.nchu.ptas.mapper.CourseMapper;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    public List<Course> getOnSellCourse(){
        return courseMapper.findByStatus(1);
    }

    public List<Map<String,Object>> getOnSellWithView(){
        return courseMapper.findOnSellWithViewByStatus(1);
    }

    public boolean checkCourse(List<Map> courses){
        List<Integer> id = new ArrayList<>();
        for(Map i : courses){
           id.add(((Course)Json.deserialization(i, Course.class)).getId());
        }
        List<Course> courseList = courseMapper.findOnSellById(id);
        return courses.size() == courseList.size();
    }

    public List courseSortByCoach(){
        List<Map<String,Integer>> getCoach = courseMapper.whoHasCourse();
        List<Integer> coachId = new ArrayList<>();
        for(Map<String,Integer> i : getCoach){
            coachId.add(i.get("coachId"));
        }
        List<Map<String,Object>> coaches = courseMapper.findCoachById(coachId);
        for(Map i : coaches){
            List<Map<String,Object>> courses = courseMapper.findByCoachId(Integer.parseInt(i.get("id").toString()));
            i.put("course",courses);
            //i.remove("id");
        }
        return coaches;
    }
}
