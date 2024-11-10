package org.example.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
// ---------------------------------- 一、了解注解切点----------------------
// 这里是Aop的增强类
// 增强类中要有增强代码
// 一般来说增强类都是以xxxAdvice为结尾
// 这里面有几个方法根据你需要插入的位置 来决定
// 2.我们会使用注解的方式来插入增强的代码
// 我们只需要写好配置文件就行了 其他的他怎么插入 怎么增强我们不用管
/*
 * 具体的生命周期如下（可以理解为生命周期）
 * 1. 前置 @Before
 * 2. 后置 @AfterReturning
 * 3. 抛出异常 @AfterThrowing
 * 4. 环绕 @Around
 * 5. 最终通知 @After
 * */
// 3. 你需要去指定 切点 你需要指定你需要吧这个增强类放到那个位置
// --------------------------  二、了解增强类中如何获取信息---------------------
/*
 * 当前问题：我们加入了日志有啥用我又不知道是谁的打印
 * 这时候我们就需要使用获取信息功能
 * */
// --------------------------  三、了解切点表达式----------------------
/*
 * execution 是啥呢 他是切点表达式
 * 固定的语法 execution(1 2 3.4.5(6))
 * 1. 访问修饰符 如public
 * 2. 返回类型 如void
 * 注意 1和2 可以写到一起用* 前置条件是你不考虑返回类型和访问修饰符
 *      但是1和2必须放到一起 要么你就写* 要么你就写具体的类型 【不能说 * void 不行的】
 * 3. 包名.类名.方法名 如org.example.service.UserService.login
 *    具体包：com.example.service.UserService
 *    单层模糊：com.example.service.*  【*表示任意包】
 *    多层模糊：com..example  ..表示中间任意层数 也就是说在com 下面 中间可以有任意层的包 然后再到example包结尾
 * 注意：.. 不能开头
 * 4. 类的名称 你需要加到那个类上
 * 5. 方法名 你需要添加的方法名 你需要加到那个方法上
 * 6. 方法参数
 *   例如我想找个又string参数的方法 (string)
 *   例如我找个有没有参数都行的方法 (..)
 *   例如我想找个有int参数的方法 (int)
 *   例如我想找个有int和string参数的方法 (int,string)
 *   例如我想找个最后一个参数是string的方法 (..string)
 * */

/*
* 练习：
1.查询某包某类下，访问修饰符是公有，返回值是int的全部方法
execution(public int 包名.类名.*(..))
2.查询某包下类中第一个参数是String的方法
execution(* 包名.类名.*(String, ..))
3.查询全部包下，无参数的方法！
execution(*..*.*())
4.查询com包下，以int参数类型结尾的方法
execution(* 包名..*.*(int))
5.查询指定包下，Service开头类的私有返回值int的无参数方法
execution(private int com.example.service.*.*())
* */
// --------------------------  四、了解切点表达式的复用---------------------
/*
 * 我们发现切点表达式是可以复用的一个一个写太麻烦了
 * */
@Component//你需要写component注解 增强类也要加入ioc容器
@Aspect // 这里是aspectj的注解 用来声明一个切面类

public class Logadvice {
    // 解决注解表达式的提取
    // 1.提取表达式
    // 2.使用表达式
    //我们不建议在这里写 我们建议 创建一个切点类去存储切点表达式
    //@Pointcut("org.example.pointcut.MyPointcut.pc()")
    //public void pc() {
    //
    //}

    @After("org.example.pointcut.MyPointcut.pc()")
    public void start(JoinPoint joinPoint) {
        //获取信息 解决不知道是谁的打印问题
        /*
         *在 JoinPoint 类中有很多方法可以获取信息
         * 1. getArgs() 获取方法参数
         * 2. getSignature() 获取方法签名
         * 3. getTarget() 获取目标对象
         *  */
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("类名：" + className + " 方法名：" + methodName + " 参数：" + args);

        System.out.println("方法开始了");
    }

    @Before("org.example.pointcut.MyPointcut.pc()")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing(value = "org.example.pointcut.MyPointcut.pc()", throwing = "e")
    // 你想获取异常信息 你需要在注解上加入throwing="e"
    // 这里的e就是异常对象
    public void error(Exception e) {
        System.out.println("方法报错了" + e.getMessage());
    }

    @AfterReturning(value = "org.example.pointcut.MyPointcut.pc()", returning = "result")
    /*
     * 你想获取返回值结果 你需要在注解上加入returning="result"
     * */
    public void success(Object result) {
        System.out.println("返回值" + result);
    }
}
