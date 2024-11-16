package org.example.pojo;

import lombok.Data;

//订单实体类
@Data
public class Order {
    private Integer orderId;
    private Integer customerId;
    private String orderName;
    //    一个订单对应一个客户
    //我们只需要在一对一中添加对应的属性即可
    private Customer customer;
}
