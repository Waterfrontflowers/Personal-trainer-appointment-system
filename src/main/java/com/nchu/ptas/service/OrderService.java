package com.nchu.ptas.service;

import com.nchu.ptas.entity.Order;
import com.nchu.ptas.mapper.OrderMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public Order newOrder(Order order){
        orderMapper.newOrder(order);
        return orderMapper.findById(order.getId()).get(0);
    }
}
