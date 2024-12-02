package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.Headline;
import org.example.pojo.vo.Header;
import org.example.utils.Result;

/**
 * @author Joon
 * @description 针对表【news_headline】的数据库操作Service
 * @createDate 2024-12-01 15:15:00
 */
public interface HeadlineService extends IService<Headline> {
    Result findNewPage(Header header);

    Result DetailHeader(Integer id);

    Result publishHeader(Headline headline, String token);

    Result ChangeHeader(Headline headline);

    Result deleteHeader(Integer id);
}
