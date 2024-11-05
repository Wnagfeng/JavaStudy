import org.example.config.MyConfiguration;
import org.example.ioc_01.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        // 创建方式一：通过注解配置类创建ApplicationContext
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);

        // 创建方式二：
        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
        applicationContext1.register(MyConfiguration.class);
        applicationContext1.refresh(); //ioc di
        StudentController bean = applicationContext.getBean(StudentController.class);
        StudentController bean1 = applicationContext1.getBean(StudentController.class);
        System.out.println(bean ); //
        System.out.println(bean1); //
    }
}
