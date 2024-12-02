package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.HeadlineMapper;
import org.example.pojo.Headline;
import org.example.pojo.vo.Header;
import org.example.service.HeadlineService;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joon
 * @description 针对表【news_headline】的数据库操作Service实现
 * @createDate 2024-12-01 15:15:00
 */
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
        implements HeadlineService {
    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result findNewPage(Header header) {
        //进行分页查询
        // 注意我们需要自定义语句携带分页参数
        // 注意返回的结果应该是list<Map>
        System.out.println("HeaderLineServiceImpl.findNewPage: " + header);
        //这里一定要包含当前页数和每页显示的条数
        IPage<Map> page = new Page<>(header.getPageNu(), header.getPageSize());
        headlineMapper.selectPage(page, header);
        System.out.println("Page: " + page);
        List<Map> records = page.getRecords();// 获取当前页数据
        Map data = new HashMap();
        data.put("pageData", records);
        data.put("total", page.getTotal());
        data.put("current", page.getCurrent());
        data.put("size", page.getSize());
        Map pageInfo = new HashMap();
        pageInfo.put("pageinfo", data);
        return Result.ok(pageInfo);


    }

    @Override
    public Result DetailHeader(Integer id) {
        // 根据id查询头条详情
        System.out.println("HeadlineServiceImpl.DetailHeader: " + id);
        // 阅读量加一：乐观锁机制
        // 查询对应的详情数据
        Map data = headlineMapper.selectById(id);
        Map headerline = new HashMap();
        headerline.put("headerline", data);
        // 更新阅读量
        Headline headline = new Headline();
        headline.setHid((Integer) data.get("hid"));
        headline.setVersion((Integer) data.get("version"));
        headline.setPageViews((Integer) data.get("pageViews") + 1);
        System.out.println("HeadlineServiceImpl.DetailHeader: " + headline);
        System.out.println("HeadlineServiceImpl.DetailHeader_id: " + data.get("hid"));
        headlineMapper.updateById(headline);
        return Result.ok(headerline);
        //return null;
    }

    @Override
    public Result publishHeader(Headline headline, String token) {
        // 补全数据
        //根据Token获取用户信息
        Integer userId = Math.toIntExact(jwtHelper.getUserId(token));
        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        //headline.setVersion(1);
        // 插入数据
        headlineMapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result ChangeHeader(Headline headline) {
        // 根据id查询最新的version
        // 数据的修改时间为当前时间
        Map map = headlineMapper.selectById(headline.getHid());
        Integer version = (Integer) map.get("version");
        headline.setVersion(version);
        headline.setUpdateTime(new Date());
        headlineMapper.updateById(headline);
        return Result.ok(null);
        // 更新数据
    }

    @Override
    public Result deleteHeader(Integer id) {
        // 根据id删除头条
        headlineMapper.deleteById(id);
        return Result.ok(null);
    }


}




