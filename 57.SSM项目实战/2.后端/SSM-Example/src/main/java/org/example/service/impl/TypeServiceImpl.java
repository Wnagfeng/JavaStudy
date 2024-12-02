package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.TypeMapper;
import org.example.pojo.Type;
import org.example.service.TypeService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joon
 * @description 针对表【news_type】的数据库操作Service实现
 * @createDate 2024-12-01 15:15:00
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Result getCategoryList() {
        List<Type> categoryList = typeMapper.selectList(null);
        return Result.ok(categoryList);
    }
}




