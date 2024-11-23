package org.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Student;

@Mapper
public interface StudentMapper {
  List<Student> selectAll();

  //    插入学生
  void insertStudent(Student student);

  //    删除学生
  void deleteStudent(int id);

  //    根据id更新学生 有两个参数的时候，需要使用@Param
  void updateStudent(@Param("id") int id, @Param("student") Student student);

  //    根据id获取学生
  Student selectById(int id);
}
