package org.example.pojo;

public class Employee {
    private Integer emp_id; // 自增主键 ID
    private String name; // 员工姓名
    private Double empSalary; // 员工工资

    // Getter 和 Setter

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}
