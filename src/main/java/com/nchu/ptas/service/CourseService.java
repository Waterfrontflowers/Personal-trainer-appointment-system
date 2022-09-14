package com.nchu.ptas.service;

import com.nchu.ptas.entity.Course;
import com.nchu.ptas.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public boolean checkCourse(List<Course> courses){
        List<Integer> id = new ArrayList<>();
        for(Course i : courses){
            id.add(i.getId());
        }
        List<Course> courseList = courseMapper.findOnSellById(id);
        return courses.size() == courseList.size();
    }

}
