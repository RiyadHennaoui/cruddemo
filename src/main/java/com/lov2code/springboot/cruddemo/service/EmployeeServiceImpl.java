package com.lov2code.springboot.cruddemo.service;

import com.lov2code.springboot.cruddemo.dao.EmployeeDao;
import com.lov2code.springboot.cruddemo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<EmployeeEntity> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public EmployeeEntity findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public void save(EmployeeEntity employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
