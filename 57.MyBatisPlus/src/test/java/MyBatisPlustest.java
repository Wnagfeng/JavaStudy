import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

    //    LambdaQueryWrapper的使用
    @Test
    public void testLambdaQuery() {
        //Users::getId 等价于 users.getId() 这是Java8的新特性

        List<Users> userList = userMapper.selectList(Wrappers.<Users>lambdaQuery().eq(Users::getId, 1));
        for (Users user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testLambdaQuery1() {
        LambdaQueryWrapper<Users> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Users::getId, 1);
        List<Users> userList = userMapper.selectList(lambdaQueryWrapper);
        for (Users user : userList) {
            System.out.println(user);
        }

    }

    //    演示LambadaUpdateWrapper的使用
    @Test
    public void testLambdaUpdate() {
        LambdaQueryWrapper<Users> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Users::getId, 1);
        Users user = new Users();
        user.setName("test");
        user.setEmail("test@test.com");
        int update = userMapper.update(user, lambdaQueryWrapper);
        System.out.println(update);
    }

    //    测试逻辑删除
    @Test
    public void testLogicDelete() {
        userMapper.deleteById(2);
    }

    @Test
    void getallUusers() {
        List<Users> users = userMapper.selectList(null);
        System.out.println("获取所有用户");
        for (Users user : users) {
            System.out.println(user);
        }
    }

    //    测试乐观lock(同时添加俩数据)
    @Test
    public void testOptimisticLock() {
        Users user1 = userMapper.selectById(5);
        Users user2 = userMapper.selectById(5);
        user1.setName("user1");
        user2.setName("user2");
        userMapper.updateById(user1);
        userMapper.updateById(user2);
    }

    //    测试全表操作
    @Test
    public void testAllTable() {
        userMapper.delete(null);
        userMapper.selectList(null).forEach(System.out::println);
    }

//


}
