import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.customerMapper;
import org.example.pojo.Customer;
import org.example.pojo.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test1 {
    private SqlSession sqlSession;
    private customerMapper mapper;

    @BeforeEach
    public void setUp() throws IOException {
        // 读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取代理mapper对象
        mapper = sqlSession.getMapper(customerMapper.class);


    }

    @AfterEach
    public void tearDown() {
        // 提交事务并关闭SqlSession对象
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() {
        // 测试查询所有订单信息
        List<Customer> customers = mapper.queryList();
        for (Customer customer : customers) {
            List<Order> orderList = customer.getOrderList();
            System.out.println(orderList);

        }
    }


}
