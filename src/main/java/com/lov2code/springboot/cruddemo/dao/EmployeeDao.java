package com.lov2code.springboot.cruddemo.dao;

import com.lov2code.springboot.cruddemo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDao {

    public List<EmployeeEntity> findAll();

    public EmployeeEntity findById(int id);

    public void save(EmployeeEntity employee);

    public void deleteById(int id);

}
