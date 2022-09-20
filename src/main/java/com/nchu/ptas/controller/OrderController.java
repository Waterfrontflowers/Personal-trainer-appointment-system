package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Order;
import com.nchu.ptas.entity.OrderItem;
import com.nchu.ptas.entity.User;
import com.nchu.ptas.service.*;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@RestController
@RequestMapping("/ptas")
public class OrderController {

    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("/newOrder")
    @ResponseBody
    public Json newOrder(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token,@RequestBody List<Map> course){
        //List<Map> course = (List<Map>) request.get("course");
        if(course==null || course.size()==0){
            return Json.response(106,"缺少参数");
        }

        if(!courseService.checkCourse(course)){
            return Json.response(120,"库存不足");
        }

        if(tokenService.tokenCheck(openId,token)){
            User user =  userService.userInfo(openId);
            Order order = new Order();
            order.setUserId(user.getId());
            order = orderService.newOrder(order);

            int count = 0;
            for(Map map : course){
                OrderItem item = new OrderItem();
                item.setCourseId(Integer.parseInt(map.get("id").toString()));
                item.setOrderId(order.getId());
                item.setQuantity(1);
                if(orderItemService.addItem(item)){
                    count++;
                }
            }
            order = orderService.findById(order.getId());
            if(course.size() == count) {
                return Json.response(200, "success", order);
            }
            else {
                return Json.response(201,"部分商品超出库存",order);
            }
        }

        return Json.response(100,"鉴权错误");
    }

    @GetMapping("/orderItemList")
    @ResponseBody
    public Json orderItem(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token ,OrderItem orderItem){
        if(!tokenService.tokenCheck(openId, token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(openId);
        if(orderItem.getOrderId() == 0){
            return Json.response(106,"缺少参数");
        }
        Order order = orderService.findById(orderItem.getOrderId());
        if(order == null){
            return Json.response(107,"异常参数");
        }
        if(order.getUserId()!= user.getId()){
            return Json.response(101,"越权访问");
        }
        return Json.response(200,"success", orderItemService.getListByOrderId(order.getId()));
    }


    @GetMapping("/orderList")
    @ResponseBody
    public Json order(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token){
        if(!tokenService.tokenCheck(openId,token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(openId);
        return Json.response(200,"success",orderService.findByUserId(user.getId()));
    }

    @PostMapping("/pay")
    @ResponseBody
    public Json pay(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token,@RequestBody Order order){
        if(!tokenService.tokenCheck(openId,token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(openId);

        if(order.getId() == 0){
            return Json.response(106,"缺少参数");
        }
        order = orderService.findById(order.getId());
        if(order == null){
            return Json.response(107,"异常参数");
        }
        if(order.getUserId()!= user.getId()){
            return Json.response(101,"越权访问");
        }
        if(order.getStatus()!= 10){
            return Json.response(110,"请勿重复支付或在非等待支付的订单上进行支付操作");
        }
        orderService.pay(order.getId());
        return Json.response(200,"success");
    }

    @PostMapping("/cancelOrder")
    @ResponseBody
    public Json cancel(@CookieValue(value = "openId",defaultValue = "") String openId,@CookieValue(value = "token",defaultValue = "") String token,@RequestBody Order order){
        if(!tokenService.tokenCheck(openId,token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(openId);
        if(!orderService.checkOrder(user.getId(),order.getId())){
            return Json.response(101,"越权访问");
        }
        if(orderService.cancelOrder(order.getId())){
            return Json.response(200,"success");
        }
        return Json.response(120,"请勿重复提交");
    }
}
