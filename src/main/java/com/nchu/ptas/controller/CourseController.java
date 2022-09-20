package com.nchu.ptas.controller;

import com.nchu.ptas.service.CourseService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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

}
