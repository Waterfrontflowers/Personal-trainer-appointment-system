package com.nchu.ptas.service;

import com.nchu.ptas.entity.OrderItem;
import com.nchu.ptas.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-15
 */
@Service
public class OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;

    public boolean addItem(OrderItem orderItem){
        orderItemMapper.addOrderItem(orderItem);
        if(orderItem.getSuccess() == 1) {
            return true;
        }
        return false;
    }

    public List<Map<String,Object>> getListByOrderId(int orderId){
        return orderItemMapper.findByOrderId(orderId);
    }
}
