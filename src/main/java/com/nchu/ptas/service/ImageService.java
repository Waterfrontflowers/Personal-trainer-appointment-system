package com.nchu.ptas.service;

import com.nchu.ptas.entity.Image;
import com.nchu.ptas.entity.User;
import com.nchu.ptas.mapper.ImageMapper;
import com.nchu.ptas.mapper.UserMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author Ginger
 * @date 2022-09-13
 */
@Service
public class ImageService {

    private final String HOST = "https://harmonyosnchu.com";
    final String HOME = "C:/nginx-1.22.0/html";
    @Autowired
    ImageMapper imageMapper;
    @Autowired
    UserMapper userMapper;


    public List<Image> userGetSlideshow(){
        List<Image> image = imageMapper.findByUsedSlideshow();
        for(Image i : image){
            i.setUrl(HOST + i.getUrl());
        }
        return image;
    }

    public String saveUserImageOnDisk(HttpServletRequest request){
        String fileName = "/image/user/" + UUID.randomUUID() + "-" + Long.toHexString(System.currentTimeMillis()) + ".jpg";
        File targetFile = new File(HOME + fileName);
        try {
            ServletInputStream inputStream = request.getInputStream();
            // org.apache.commons.io.FileUtils
            FileUtils.copyInputStreamToFile(inputStream, targetFile);

        }
        catch (Exception e){
            return null;
        }
        return fileName;
    }

    public boolean saveUserImage(User user, String url){
        Image image = new Image();
        image.setUrl(url);
        image.setUsed(true);
        image.setCategory(3);
        imageMapper.save(image);
        List<Image> images = imageMapper.findByUrl(url);
        if(images.isEmpty()){
            return false;
        }
        image = images.get(0);
        if(user.getImageId() != 0){
            imageMapper.doNotUsed(user.getImageId());
        }
        userMapper.updateImage(user.getId(),image.getPicId());
        return true;
    }

    public Image findById(int id){
        return imageMapper.findById(id).get(0);
    }
}
