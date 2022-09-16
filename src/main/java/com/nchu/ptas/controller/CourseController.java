package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Course;
import com.nchu.ptas.service.CourseService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@RestController
@RequestMapping("/ptas")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/course")
    @ResponseBody
    public Json course(){
        return Json.response(200,"success",courseService.getOnSellWithView());
    }

    @RequestMapping("/courseSortByCoach")
    @ResponseBody
    public Json courseSortByCoach(){
        return Json.response(200,"success",courseService.courseSortByCoach());
    }

  /*  @RequestMapping("/test")
    @ResponseBody
    public Json test(@RequestBody List<Course> request){

       // List<Course> list = (List<Course>) Json.deserialization(request,List.class);
        return Json.response(200,"success",courseService.checkCourse(request));
    }*/
}
