package com.lov2code.springboot.cruddemo.rest;

import com.lov2code.springboot.cruddemo.dao.EmployeeDao;
import com.lov2code.springboot.cruddemo.entity.EmployeeEntity;
import com.lov2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/employees")
    public List<EmployeeEntity> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    public EmployeeEntity findEmployeeById(@PathVariable int employeeid){
        EmployeeEntity employee = employeeService.findById(employeeid);

        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeid);
        }
        return employee;
    }

    @PostMapping("/employees")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee){


        employee.setId(0);

        employeeService.save(employee);

        return employee;


    }

    @PutMapping("/employees")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee){
        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        EmployeeEntity employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }


}
