package com.lov2code.springboot.cruddemo.dao;

import com.lov2code.springboot.cruddemo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployeeEntity> findAll() {

        TypedQuery<EmployeeEntity> query = entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class);

        List<EmployeeEntity> employeeEntities = query.getResultList();

        return employeeEntities;
    }

    @Override
    public EmployeeEntity findById(int id) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
        return employee;
    }

    @Override
    public void save(EmployeeEntity employee) {
        entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("delete from EmployeeEntity where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
