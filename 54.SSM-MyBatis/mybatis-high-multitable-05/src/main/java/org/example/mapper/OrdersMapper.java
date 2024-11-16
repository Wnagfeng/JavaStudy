package org.example.mapper;

import org.example.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    //    获取所有的订单信息
    public List<Orders> selectAllOrders();
}
