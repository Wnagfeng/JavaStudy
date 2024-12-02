package org.example.pojo.vo;

import lombok.Data;
// 这是前端传递的查询Json对象
@Data
public class Header {
    private String keywords;
    private int type;
    private int pageNu = 1;
    private int pageSize = 10;
}
