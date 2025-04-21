package com.ems.controller;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee savedEmp = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee> (savedEmp, HttpStatus.CREATED);
    }
    @GetMapping("/getEmp")
    public ResponseEntity<List<Employee>> getEmployee(){
        List<Employee> empList = employeeService.getEmployee();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }
    @GetMapping("/getEmp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);

    }
    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmp(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
