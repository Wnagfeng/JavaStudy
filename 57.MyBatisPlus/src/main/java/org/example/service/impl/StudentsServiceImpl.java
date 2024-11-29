package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.Students;
import org.example.service.StudentsService;
import org.example.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

/**
* @author Joon
* @description 针对表【students】的数据库操作Service实现
* @createDate 2024-11-29 22:04:32
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

}




