package com.ems.service;

import com.ems.entity.Employee;
import com.ems.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee savedEmployee = employeeRepo.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public void deleteEmp(Long id) {
        employeeRepo.deleteById(id);

    }


}
