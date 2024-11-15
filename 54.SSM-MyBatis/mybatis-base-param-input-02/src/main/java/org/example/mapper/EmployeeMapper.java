package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee selectEmployee(int id);

    int DeleteByID(int id);

    List<Employee> selectbySalary(double salary);

    int insertEmployee(Employee employee);

    //    根据员工姓名和工资查询员工信息
    List<Employee> selectByNameAndSalary(@Param("name") String name, @Param("salary") double salary);

    //    插入员工数据传入map 参数
    int insertEmployeeByMap(Map data);
}
