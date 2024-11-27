import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.MainApplication;
import org.example.mappers.UserMapper;
import org.example.pojo.Users;
import org.example.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MainApplication.class)
public class MyBatisPlustest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test() {
        List<Users> userList = userMapper.selectList(null);
        for (Users user : userList) {
            System.out.println(user);
        }

    }

    //    测试add
    @Test
    public void testAdd() {
        Users user = new Users();
        user.setName("test");
        user.setEmail("test@test.com");
        userMapper.insert(user);
    }


    // 测试saveorupdate
    @Test
    public void testSaveOrUpdate() {
        Users user = new Users();
        user.setId(1);
        user.setName("Alice");
        user.setEmail("testAliceChanged@test.com");
        userService.saveOrUpdate(user);
    }

    //    测试分页
    @Test
    public void testPage() {
        //IPage
        Page<Users> page = new Page<>(1, 2);
        userMapper.selectPage(page, null);
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
    }

    //     QueryMapper的使用
    @Test
    public void testQuery() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("id", 1);
        //name 包含e email 包含test
        queryWrapper.like("name", "e");

        List<Users> userList = userMapper.selectList(queryWrapper);
        for (Users user : userList) {
            System.out.println(user);
        }
    }

    //     更具id降序查询
    @Test
    public void testOrderByDesc() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<Users> userList = userMapper.selectList(queryWrapper);
        for (Users user : userList) {
            System.out.println(user);
        }
    }


}
