package com.example.SpringBootDev.service;


import com.example.SpringBootDev.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByLastName();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
