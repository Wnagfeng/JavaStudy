import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class testHomeWorke {
    @Test
    public void testHomeWorke() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        //StudentController studentController = (StudentController) context.getBean(StudentController.class);
        StudentController studentController = (StudentController) context.getBean("studentController");
        System.out.println(studentController.getAllStudents());
        System.out.println(studentController);
        System.out.println("Hello World");
    }
}
