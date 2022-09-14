package com.nchu.ptas.controller;

import com.nchu.ptas.entity.Order;
import com.nchu.ptas.entity.Token;
import com.nchu.ptas.entity.User;
import com.nchu.ptas.service.OrderService;
import com.nchu.ptas.service.TokenService;
import com.nchu.ptas.service.UserService;
import com.nchu.ptas.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    OrderService orderService;

    @RequestMapping("newOrder")
    @ResponseBody
    public Json newOrder(@RequestBody Map<String,Object> request){
        Token token = (Token) Json.deserialization(request,Token.class);
        if(tokenService.tokenCheck(token)){
            User user =  userService.userInfo(token.getOpenId());
            Order order = (Order) Json.deserialization(request, Order.class);
            order.setUserId(user.getId());
            order = orderService.newOrder(order);
            return Json.response(200,"success",order);
        }

        return Json.response(100,"鉴权错误");
    }
}
