import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.ExampleMapper;
import org.example.pojo.Example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest1 {
    private SqlSession sqlSession;
    private ExampleMapper mapper;

    @BeforeEach
    public void setUp() throws IOException {
        // 读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取代理mapper对象
        mapper = sqlSession.getMapper(ExampleMapper.class);


    }

    @AfterEach
    public void tearDown() {
        // 提交事务并关闭SqlSession对象
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void test() {
        Example example = new Example();
        example.setName("test");

        // 执行插入操作
        int result = mapper.insert(example);

        // 获取插入后生成的 ID
        String id = example.getId();


        System.out.println("插入结果: " + result);
        System.out.println("生成的 ID: " + id);
    }


}
