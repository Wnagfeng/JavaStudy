package org.example.Mapper;

import org.example.pojo.Orders;

import java.util.List;

public interface OrderMapper {
    public List<Orders> selectAllOrders();
}
