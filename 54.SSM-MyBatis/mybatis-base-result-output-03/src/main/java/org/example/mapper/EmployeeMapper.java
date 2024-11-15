package org.example.mapper;

import org.example.pojo.Employee;
import org.example.pojo.Example;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //   如果是插入 修改 删除 返回值都是int类型
    int insert(Example employee);

    //    指定输出语句类型
    //    根据员工的id查询员工姓名
    String selectNameById(int id);

    //     根据员工的id查询员工信息
    Employee selectById(int id);

    //    查询返回Map类型
    Map<String, Object> selectEmpNameAndMaxSalary();

    //    查询工资高于某个值的员工信息
    List<Employee> selectBySalaryGreaterThan(int salary);

    //    查询全部员工相信
    List<Employee> selectAll();

    //    插入员工信息
    int insertEmployee(Employee employee);
}
