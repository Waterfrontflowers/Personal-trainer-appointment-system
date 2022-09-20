package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Image;
import com.nchu.ptas.entity.User;
import com.nchu.ptas.service.ImageService;
import com.nchu.ptas.service.TokenService;
import com.nchu.ptas.service.UserService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Ginger
 * @date 2022-09-13
 */
@RestController
@RequestMapping("/ptas")
public class ImageController {

    @Autowired
    ImageService imageService;
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;

    @RequestMapping("/image/slideshow")
    @ResponseBody
    public Json slideshow(){
        return Json.response(200,"success",imageService.userGetSlideshow());
    }

    @PostMapping(value = "/newUserImage")
    public Json newUserImage(@CookieValue(value = "openId",defaultValue = "") String openId, @CookieValue(value = "token",defaultValue = "") String token , HttpServletRequest request) throws IOException {
        if(!tokenService.tokenCheck(openId,token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(openId);
        String url = imageService.saveUserImageOnDisk(request);
        if(url == null){
            return Json.response(500,"服务器故障");
        }
        imageService.saveUserImage(user,url);
        return Json.response(200,"success");
    }

    @GetMapping("/userImage")
    @ResponseBody
    public Json userImage(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token){
        if(!tokenService.tokenCheck(openId,token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(openId);
        Image image = imageService.findById(user.getImageId());
        return Json.response(200,"success",image);
    }

}
