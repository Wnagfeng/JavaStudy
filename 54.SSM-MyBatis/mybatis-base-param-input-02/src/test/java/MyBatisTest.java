import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.EmployeeMapper;
import org.example.pojo.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyBatisTest {
    private SqlSession sqlSession;
    private EmployeeMapper mapper;

    @BeforeEach
    public void setUp() throws IOException {
        // 读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取代理mapper对象
        mapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    @AfterEach
    public void tearDown() {
        // 提交事务并关闭SqlSession对象
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectEmployeeById() {
        Employee employee = mapper.selectEmployee(1); // 根据实际的ID进行查询
        assertNotNull(employee, "查询结果不应为null");
        System.out.println("查询成功: " + employee);
    }


}
