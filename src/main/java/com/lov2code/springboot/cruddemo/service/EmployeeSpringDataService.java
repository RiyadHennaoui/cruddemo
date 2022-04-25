package com.lov2code.springboot.cruddemo.service;

import com.lov2code.springboot.cruddemo.dao.EmployeeDao;
import com.lov2code.springboot.cruddemo.dao.EmployeeRepository;
import com.lov2code.springboot.cruddemo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class EmployeeSpringDataService implements EmployeeService{

    private EmployeeRepository employeeDao;

    @Autowired
    public EmployeeSpringDataService(EmployeeRepository employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public EmployeeEntity findById(int id) {
        Optional<EmployeeEntity> result = employeeDao.findById(id);

        EmployeeEntity employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException("Did not find employee id " + id);
        }
        return employee;
    }

    @Override
    public void save(EmployeeEntity employee) {
        employeeDao.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

}
