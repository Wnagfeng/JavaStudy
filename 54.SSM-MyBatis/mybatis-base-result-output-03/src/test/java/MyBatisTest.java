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
import java.util.List;
import java.util.Map;

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
        Employee employee = mapper.selectById(1); // 根据实际的ID进行查询
        assertNotNull(employee, "查询结果不应为null");
        System.out.println("查询成功: " + employee);
    }


    @Test
    public void testSelectEmployeeByName() {
        Map<String, Object> result = mapper.selectEmpNameAndMaxSalary(); // 获取查询结果
        assertNotNull(result, "查询结果不应为null");
        System.out.println("查询成功: " + result);

        String employeeName = (String) result.get("员工姓名"); // 获取员工姓名
        Double employeeSalary = (Double) result.get("员工工资"); // 获取员工工资
        Double departmentAverageSalary = (Double) result.get("部门平均工资"); // 获取部门平均工资

        System.out.println("姓名: " + employeeName + ", 工资: " + employeeSalary + ", 部门平均工资: " + departmentAverageSalary);
    }

    @Test
    public void test1() {
        List<Employee> mapp = mapper.selectBySalaryGreaterThan(1);
        assertNotNull(mapp, "查询结果不应为null");
        System.out.println("查询成功: " + mapp);
    }

    @Test
    public void test2() {
        Employee employee = new Employee();
        employee.setName("Joon");
        employee.setEmpSalary(10000.0);

        // 执行插入操作
        int result = mapper.insertEmployee(employee);

        // 获取插入后生成的 ID
        Integer generatedId = employee.getEmp_id(); // 此时 id 应该已经自动填充
        System.out.println(employee.getName());

        System.out.println("插入结果: " + result);
        System.out.println("生成的 ID: " + generatedId);
    }


}
