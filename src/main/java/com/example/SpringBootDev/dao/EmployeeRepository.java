package com.example.SpringBootDev.dao;


import com.example.SpringBootDev.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Spring Data JPA automatically creates method implementation
    //findAllBy - find all
    //OrderByLastName - order by attribute name
    //Asc - Sorting order
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    List<Employee> findAllByOrderByLastNameAsc();
}
