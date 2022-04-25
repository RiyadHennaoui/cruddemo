package com.lov2code.springboot.cruddemo.dao;

import com.lov2code.springboot.cruddemo.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{


    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployeeEntity> findAll() {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        //create query

        Query<EmployeeEntity> query = currentSession.createQuery("from EmployeeEntity", EmployeeEntity.class);

        //execute query and get result list

        //return the result


        return query.getResultList();
    }

    @Override
    public EmployeeEntity findById(int id) {

        Session session = entityManager.unwrap(Session.class);

        return session.get(EmployeeEntity.class, id);

//        return getCurrentSession().get(EmployeeEntity.class, id);
    }

    @Override
    public void save(EmployeeEntity employee) {
        getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Query query = getCurrentSession().createQuery("delete from EmployeeEntity where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    private Session getCurrentSession(){
        Session session = entityManager.unwrap(Session.class);
        return session;
    }


}
