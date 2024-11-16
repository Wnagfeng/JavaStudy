package org.example.mapper;

import org.example.pojo.Order;

// 查询订单接口
public interface orderMapper {
    //     根据id查询订单信息并且获取到订单对应的客户
    Order selectOrderAndCustomerById(Integer id);
}
