import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.orderMapper;
import org.example.pojo.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {
    private SqlSession sqlSession;
    private orderMapper mapper;

    @BeforeEach
    public void setUp() throws IOException {
        // 读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取代理mapper对象
        mapper = sqlSession.getMapper(orderMapper.class);


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
        Order order = mapper.selectOrderAndCustomerById(1);
        System.out.println("查询到的订单信息为：" + order);

    }


}
