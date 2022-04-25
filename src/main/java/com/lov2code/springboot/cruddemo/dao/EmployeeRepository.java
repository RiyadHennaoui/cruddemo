package com.lov2code.springboot.cruddemo.dao;

import com.lov2code.springboot.cruddemo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
