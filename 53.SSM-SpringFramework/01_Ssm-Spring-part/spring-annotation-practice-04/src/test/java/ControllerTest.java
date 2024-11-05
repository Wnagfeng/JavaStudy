import org.example.controller.studentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControllerTest {

    @Test
    public void testRun() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("springioc.xml");
        studentController studentController = applicationContext.getBean(studentController.class);
        studentController.findAll();
    }
}