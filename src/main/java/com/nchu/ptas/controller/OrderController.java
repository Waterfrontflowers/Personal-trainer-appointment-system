package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Order;
import com.nchu.ptas.entity.OrderItem;
import com.nchu.ptas.entity.Token;
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
    public Json newOrder(@RequestBody Map<String,Object> request){
        Token token = (Token) Json.deserialization(request,Token.class);
        List<Map> course = (List<Map>) request.get("course");
        if(!courseService.checkCourse(course)){
            return Json.response(106,"库存不足");
        }

        if(tokenService.tokenCheck(token)){
            User user =  userService.userInfo(token.getOpenId());
            Order order = (Order) Json.deserialization(request, Order.class);
            order.setUserId(user.getId());
            order = orderService.newOrder(order);

            int count = 0;
            for(Map map : course){
                OrderItem item = (OrderItem) Json.deserialization(map,OrderItem.class);
                item.setOrderId(order.getId());
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

    @PostMapping("/orderItemList")
    @ResponseBody
    public Json orderItem(@RequestBody Map<String,Object> request){
        Token token = (Token) Json.deserialization(request,Token.class);
        OrderItem orderItem = (OrderItem) Json.deserialization(request,OrderItem.class);
        if(!tokenService.tokenCheck(token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(token.getOpenId());
        if(request.get("orderId") == null){
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


    @PostMapping("/orderList")
    @ResponseBody
    public Json order(@RequestBody Map<String,Object> request){
        Token token = (Token) Json.deserialization(request,Token.class);
        OrderItem orderItem = (OrderItem) Json.deserialization(request,OrderItem.class);
        if(!tokenService.tokenCheck(token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(token.getOpenId());
        return Json.response(200,"success",orderService.findByUserId(user.getId()));
    }

    @PostMapping("/pay")
    @ResponseBody
    public Json pay(@RequestBody Map<String,Object> request){
        Token token = (Token) Json.deserialization(request,Token.class);
        if(!tokenService.tokenCheck(token)){
            return Json.response(100,"鉴权错误");
        }
        User user =  userService.userInfo(token.getOpenId());

        if(request.get("orderId") == null){
            return Json.response(106,"缺少参数");
        }
        Order order = orderService.findById(Integer.parseInt(request.get("orderId").toString()));
        if(order == null){
            return Json.response(107,"异常参数");
        }
        if(order.getUserId()!= user.getId()){
            return Json.response(101,"越权访问");
        }
        if(order.getPaymentTime() != null){
            return Json.response(110,"请勿重复支付");
        }
        orderService.pay(order.getId());
        return Json.response(200,"success");
    }
}
