package com.lov2code.springboot.cruddemo.dao;

import com.lov2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
}
