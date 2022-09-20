package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.Order;
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

    /**
     * 取消订单
     * @param map 需要有key为orderId
     * @return map中key为success
     */
    Map<String,Integer> cancelOrder(Map<String,Integer> map);

    /**
     * 检查是否有权限操作订单
     * @param userId 用户id
     * @param orderId 订单号
     * @return 查找结果
     */
    List<Order> checkOrder(int userId,int orderId);
}
