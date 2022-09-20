package com.nchu.ptas.service;

import com.nchu.ptas.entity.Order;
import com.nchu.ptas.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public Order newOrder(Order order) {
        orderMapper.newOrder(order);
        return orderMapper.findById(order.getId()).get(0);
    }

    public Order findById(int id) {
        List<Order> orderList = orderMapper.findById(id);
        if(orderList.isEmpty()){
            return null;
        }
        else{
            return orderList.get(0);
        }
    }

    public List<Order> findByUserId(int userId) {
        return orderMapper.findByUserId(userId);
    }

    public void pay(int id){
        orderMapper.pay(id);
    }

    public boolean cancelOrder(int orderId){
        Map<String,Integer> map = new HashMap<String,Integer>(2);
        map.put("orderId",orderId);
        orderMapper.cancelOrder(map);
        if(map.get("success") == 0){
            return false;
        }
        return true;
    }

    public boolean checkOrder(int userId,int orderId){
        return !orderMapper.checkOrder(userId,orderId).isEmpty();
    }

}
