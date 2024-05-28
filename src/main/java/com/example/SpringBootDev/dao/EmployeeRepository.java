package com.example.SpringBootDev.dao;


import com.example.SpringBootDev.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
