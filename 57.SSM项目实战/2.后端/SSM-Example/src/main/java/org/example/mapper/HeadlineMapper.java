package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Headline;
import org.example.pojo.vo.Header;

import java.util.Map;

/**
 * @author Joon
 * @description 针对表【news_headline】的数据库操作Mapper
 * @createDate 2024-12-01 15:15:00
 * @Entity org.example.pojo.Headline
 */
public interface HeadlineMapper extends BaseMapper<Headline> {
    //在你的方法中，header 参数通过 @Param("header") 被命名为 header，这样在 SQL 查询中就可以通过 #{header} 来引用这个参数。
    IPage<Map> selectPage(IPage<Map> page, @Param("header") Header header);

    Map selectById(Integer id);
}




