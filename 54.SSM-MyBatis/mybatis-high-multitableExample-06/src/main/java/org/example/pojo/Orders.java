package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Orders {
    private Integer OrdersId;
    private Integer UserId;
    //    1.订单和用户是一对一的关系，需要User作为属性
    private Users user;
    //    2.订单和订单详情也是一对多的关系，需要OrderDetails作为集合属性

    private List<Products> ProductsList;
}

