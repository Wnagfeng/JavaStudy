package org.example.pojo;

import lombok.Data;

import java.util.List;

//客户实体类
@Data
public class Customer {
    private Integer customerId;
    private String customerName;
    //    一对多关系，一个客户对应多个订单
//    对于这种多对一个的关系我们只需要保存它的list即可
    private List<Order> orderList;

    @Override
    public String toString() {
        return "Customer{id=" + customerId + ", name='" + customerName + "', ...}";
        // 确保包含所需的属性
    }
}
