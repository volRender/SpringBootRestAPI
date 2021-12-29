package com.litvishko.spring.boot.rest_api.spring_boot_rest_api.service;


import com.litvishko.spring.boot.rest_api.spring_boot_rest_api.dao.EmployeeDAO;
import com.litvishko.spring.boot.rest_api.spring_boot_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> showAllEmps() {
        return employeeDAO.showAllEmps();
    }

    @Override
    @Transactional
    public void addEmp(Employee employee) {
        employeeDAO.addEmp(employee);
    }

    @Override
    @Transactional
    public Employee showEmp(int id) {
        return employeeDAO.showEmp(id);
    }

    @Override
    @Transactional
    public void deleteEmp(int id) {
        employeeDAO.deleteEmp(id);
    }
}
