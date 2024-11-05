import org.example.ioc_02.BeanOne;
import org.example.ioc_03.SoldierController;
import org.example.ioc_04.CommonComponent;
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

    @Test
    public void testIoc_02() {
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("springannotation_02.xml");

        Object BeanOne1 = applicationContext.getBean(BeanOne.class);
        Object BeanOne2 = applicationContext.getBean(BeanOne.class);

        System.out.println("BeanOne = " + BeanOne1 == BeanOne2);
    }

    @Test
    public void testIoc_03() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springannotation_03.xml");
        SoldierController soldierController = (SoldierController) applicationContext.getBean("tianDog");
        //场景1: ioc容器中有一个UserService接口对应的实现类对象！
        soldierController.getMessage();
        System.out.println("tianDog = " + soldierController);
        //场景2: ioc容器没有默认的类型如何处理
        // @Autowired 使用它进行装配，【 默认 】情况下至少要求有一个bean！ 否则报错！ 可以指定佛系装配

        //场景3：同一个类型有多个对应的组件 @Autowired也会报错！ 无法选择！！
        //解决1： 成员属性名指定 @Autowired 多个组件的时候，默认会根据成员属性名查找
        //解决2： @Qualifier(value = "userServiceImpl") 使用该注解指定获取bean的id! 不能单独使用必须配合autowired

        //优化点：  @Autowired(required = true) + @Qualifier(value = "userServiceImpl") == @Resource(name="userServiceImpl")
    }

    @Test
    public void testIoc_04() {
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("springannotation_04.xml");

        CommonComponent bean = applicationContext.getBean(CommonComponent.class);

        System.out.println("bean = " + bean.getName());

    }

}
