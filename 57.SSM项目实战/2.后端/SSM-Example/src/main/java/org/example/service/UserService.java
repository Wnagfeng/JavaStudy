package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.User;
import org.example.utils.Result;

/**
 * @author Joon
 * @description 针对表【news_user】的数据库操作Service
 * @createDate 2024-12-01 15:15:00
 */
public interface UserService extends IService<User> {
    //登录业务
    Result login(User user);

    Result getUserInfo(String token);

    Result checkUsername(String username);

    Result register(User user);

    Result checkToken(String token);
}
