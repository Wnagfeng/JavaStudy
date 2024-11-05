import org.example.config.myconfig;
import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ControllerTest {

    @Test
    public void testRun() {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(myconfig.class);

        StudentController studentController = applicationContext.getBean(StudentController.class);

        System.out.println(studentController.getAllStudents());

    }
}