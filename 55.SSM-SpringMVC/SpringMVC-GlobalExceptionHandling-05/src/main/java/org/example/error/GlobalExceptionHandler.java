package org.example.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//只要发生错误就会走这个类
// 这里你可以加的注解有两个
// @RestControllerAdvice 和 @ControllerAdvice
@RestControllerAdvice // 可以返回视图也可以返回json数据 适用于前后端分离的项目
//@ControllerAdvice// 可以转发和重定向视图的异常 适用于传统的MVC项目
public class GlobalExceptionHandler {
//    如何去处理异常呢?

    //    处理算术异常
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e) {
        return "An error occurred CoderJoon: " + e.getMessage();
    }

    //    全局异常处理
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "An error occurred CoderJoon: " + e.getMessage();
    }

    //    处理空指针异常
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        return "An error occurred CoderJoon: " + e.getMessage();
    }

}
