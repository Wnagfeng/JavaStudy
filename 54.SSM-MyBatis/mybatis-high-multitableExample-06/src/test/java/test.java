import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Mapper.OrderMapper;
import org.example.pojo.Orders;
import org.example.pojo.Products;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    private SqlSession sqlSession;
    private OrderMapper mapper;

    @BeforeEach
    public void setUp() throws IOException {
        // 读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取代理mapper对象
        mapper = sqlSession.getMapper(OrderMapper.class);


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
        List<Orders> orders = mapper.selectAllOrders();
        for (Orders order : orders) {
            System.out.println("订单ID：" + order.getOrdersId());
            System.out.println("用户信息：");
            if (order.getUser() != null) {
                System.out.println("  用户ID：" + order.getUser().getUserId());
                System.out.println("  用户名：" + order.getUser().getName());
                System.out.println("  邮箱：" + order.getUser().getEmail());
            }
            System.out.println("商品列表：");
            if (order.getProductsList() != null && !order.getProductsList().isEmpty()) {
                for (Products product : order.getProductsList()) {
                    System.out.println("  商品ID：" + product.getProductId());
                    System.out.println("  商品名称：" + product.getName());
                    System.out.println("  商品价格：" + product.getPrice());
                }
            } else {
                System.out.println("  没有相关商品信息。");
            }
            System.out.println("------------------------");
        }
    }


}
