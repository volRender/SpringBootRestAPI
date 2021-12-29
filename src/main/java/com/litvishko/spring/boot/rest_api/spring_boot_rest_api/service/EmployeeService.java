package com.litvishko.spring.boot.rest_api.spring_boot_rest_api.service;



import com.litvishko.spring.boot.rest_api.spring_boot_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> showAllEmps();
    void addEmp(Employee employee);
    Employee showEmp(int id);
    void deleteEmp(int id);

}
