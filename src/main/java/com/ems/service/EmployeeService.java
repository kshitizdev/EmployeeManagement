package com.ems.service;

import com.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getEmployee();

    Employee getEmployeeById(Long id);


    void deleteEmp(Long id);
}
