package org.example.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcut {
    // 我们这个类中只存放切点
    @Pointcut("execution(* org.example.service.*.*(..))")
    public void pc() {

    }
}
