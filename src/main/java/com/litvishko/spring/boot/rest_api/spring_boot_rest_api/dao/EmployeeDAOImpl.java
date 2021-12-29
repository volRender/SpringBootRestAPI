package com.litvishko.spring.boot.rest_api.spring_boot_rest_api.dao;

import com.litvishko.spring.boot.rest_api.spring_boot_rest_api.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> showAllEmps() {
        //hibernate
//        Session session = entityManager.unwrap(Session.class);
//
//        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
//        return employees;

        //jpa only
        Query query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;

    }

    @Override
    public void addEmp(Employee employee) {
        //hibernate
//        Session session = entityManager.unwrap(Session.class);
//
//        session.saveOrUpdate(employee);


        //jpa only
        Employee newEmp = entityManager.merge(employee);
        employee.setId(newEmp.getId());
    }

    @Override
    public Employee showEmp(int id) {
        //hibernate
//        Session session = entityManager.unwrap(Session.class);
//
//        Employee employee = session.get(Employee.class, id);
//        return employee;

        //jpa only
        Employee employee = entityManager.find(Employee.class, id);
        return employee;

    }

    @Override
    public void deleteEmp(int id) {
        //hibernate
//        Session session = entityManager.unwrap(Session.class);
//
//        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        //jpa only
        Query query = entityManager.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
