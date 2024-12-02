package org.example.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtHelper;
import org.example.utils.MD5Util;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Joon
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2024-12-01 15:15:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result login(User user) {
        //登录的业务
        /*
         * 1. 校验用户名和密码是否正确
         * 2. 生成token
         * 3. 返回token
         * */
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User result = userMapper.selectOne(queryWrapper);
        if (result == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        //校验密码
        if (!StringUtils.isEmpty(result.getUserPwd()) && MD5Util.encrypt(user.getUserPwd()).equals(result.getUserPwd())) {
            //    登录成功

            String token = jwtHelper.createToken(Long.valueOf(result.getUid()));
            Map data = new HashMap();
            data.put("token", token);
            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        //根据token获取用户信息
        // 校验token的有效期
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        // 解析token获取用户id
        Long userId = jwtHelper.getUserId(token);
        System.out.println("userId:" + userId);
        // 根据用户id查询用户信息
        User user = userMapper.selectById(userId);
        System.out.println("user:" + user);
        user.setUserPwd(null);
        Map data = new HashMap();
        data.put("user", user);
        return Result.ok(data);


    }

    @Override
    public Result checkUsername(String username) {
        //校验用户名是否存在
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User result = userMapper.selectOne(queryWrapper);
        if (result == null) {
            return Result.ok(true);
        }
        return Result.build(null, ResultCodeEnum.USERNAME_USED);
    }

    //注册
    @Override
    public Result register(User user) {
        //1.校验用户名是否存在
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User result = userMapper.selectOne(queryWrapper);
        if (result != null) {
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //2.插入用户信息
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        userMapper.insert(user);
        return Result.ok(true);
    }

    @Override
    public Result checkToken(String token) {
        //校验token的有效期
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        return Result.ok(true);
    }


}




