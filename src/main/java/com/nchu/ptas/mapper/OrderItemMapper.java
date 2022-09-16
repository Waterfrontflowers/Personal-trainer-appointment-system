package com.nchu.ptas.mapper;

import com.nchu.ptas.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Ginger
 * @date 2022-09-15
 */
@Mapper
public interface OrderItemMapper {
    Map<String,Object> addOrderItem(OrderItem orderItem);

    List<Map<String,Object>> findByOrderId(int orderId);
}
