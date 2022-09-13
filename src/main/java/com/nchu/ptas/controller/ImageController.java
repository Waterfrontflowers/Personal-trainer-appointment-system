package com.nchu.ptas.controller;

import com.nchu.ptas.service.ImageService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ginger
 * @date 2022-09-13
 */
@RestController
@RequestMapping("/ptas/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping("/slideshow")
    public String slideshow(){
        return Json.jsonReturn(200,"success",imageService.userGetSlideshow());
    }
}
