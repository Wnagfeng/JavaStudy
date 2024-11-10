import org.example.config.JavaConfig;
import org.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//简化测试代码：通过使用这个注解，开发者不需要手动创建和配置 ApplicationContext，Spring 会自动完成这些工作，从而简化了测试相关的代码
// 这里我们使用spring-test 不用我们在去手动创建 ioc容器了
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAoptest {
    // 这里面的接值你必须使用接口接值，而不是具体的实现类
    // 因为 Aop底层用了代理技术 代理对象和目标对象不是一个对象 但是接口相当于一个类型能直接使用
    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd() {
        int result = calculator.add(1, 2);
        //int result1 = calculator.div(1, 0);
        System.out.println(result);
    }
}
