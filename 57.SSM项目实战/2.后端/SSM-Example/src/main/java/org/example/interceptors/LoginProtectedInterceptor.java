package org.example.interceptors;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/*
 * 检查用户是否登录的拦截器
 * */
@Component

public class LoginProtectedInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if user is logged in
        String token = request.getHeader("token");
        boolean isLogin = jwtHelper.isExpiration(token);
        if (!isLogin) {
            return true;
        }
        //这里我无效的拦截
        Result<Object> build = Result.build(null, ResultCodeEnum.NOTLOGIN);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(build);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
        // If not, redirect to login page
        // If yes, allow access to the requested resource
        return false;
    }
}
