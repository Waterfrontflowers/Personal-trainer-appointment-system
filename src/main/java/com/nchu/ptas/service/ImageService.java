package com.nchu.ptas.service;

import com.nchu.ptas.entity.Image;
import com.nchu.ptas.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ginger
 * @date 2022-09-13
 */
@Service
public class ImageService {

    private final String HOST = "https://harmonyosnchu.com";

    @Autowired
    ImageMapper imageMapper;


    public List<Image> userGetSlideshow(){
        List<Image> image = imageMapper.findByUsedSlideshow();
        for(Image i : image){
            i.setUrl(HOST + i.getUrl());
        }
        return image;

        //return imageMapper.findByUsedSlideshow();
    }
}
