import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {
    private SqlSession sqlSession;
    private UserMapper mapper;

    @BeforeEach
    public void setUp() throws IOException {
        // 读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取代理mapper对象
        mapper = sqlSession.getMapper(UserMapper.class);


    }

    @AfterEach
    public void tearDown() {
        // 提交事务并关闭SqlSession对象
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("password");
        mapper.insert(user);
        System.out.println(user.getId());
        System.out.println("插入成功");
    }

    @Test
    public void tetsupdate() {
        User user = new User();
        user.setId(1);
        user.setUsername("Joon");
        user.setPassword("password");
        mapper.update(user);
        System.out.println("更新成功");
    }

    @Test
    public void testdelete() {
        mapper.delete(1);
    }

    @Test
    public void testselectById() {
        User user = mapper.selectById(2);
        System.out.println(user.getUsername());
    }

    @Test
    public void testselectAll() {
        mapper.selectAll().forEach(System.out::println);
    }


}
