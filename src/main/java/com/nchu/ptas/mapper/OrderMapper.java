package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@Mapper
public interface OrderMapper {
    void newOrder(Order order);

    List<Order> findById(int id);

    List<Order> findByUserId(int userId);

    void pay(int id);
}
