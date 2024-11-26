package org.example.service;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.selectAll();
    }


    @Transactional
    public void deleteUser(int id) {

        userMapper.delete(id);
        //int i = 1 / 0;
    }
}
