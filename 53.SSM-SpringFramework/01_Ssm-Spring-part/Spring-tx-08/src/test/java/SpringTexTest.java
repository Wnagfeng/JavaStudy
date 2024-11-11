import org.example.config.Javaconfig;
import org.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Javaconfig.class)//注入配置文件
public class SpringTexTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void testUserService() {
        studentService.changeInfo();
    }

}
