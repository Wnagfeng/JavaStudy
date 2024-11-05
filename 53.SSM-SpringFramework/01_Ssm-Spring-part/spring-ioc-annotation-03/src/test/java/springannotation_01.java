import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springannotation_01 {
    @Test
    public void testIoc_01() {

        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("springannotation_01.xml");

        //2.获取组件
        //XxxDao bean = applicationContext.getBean(XxxDao.class);

        //System.out.println("bean = " + bean);

        //添加ioc注解,默认的组件名为 类的首字母小写!
        //Object xxxService = applicationContext.getBean("xxxService");

        //System.out.println("xxxService = " + xxxService);
        //获取指定id的组件
        Object xxxController = applicationContext.getBean("tianDog");

        System.out.println("xxxController = " + xxxController);
    }

}
