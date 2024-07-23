package com.example.SpringBootDev.rest;

import com.example.SpringBootDev.entity.Employee;
import com.example.SpringBootDev.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;


    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id) {
        Employee employee = this.employeeService.findById(id);
        if (employee != null) {
            return employee;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        this.employeeService.save(employee);
        return employee;
    }

    @PatchMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable int id) {
        Employee employee = this.employeeService.findById(id);
        if (employee != null) {
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setEmail(newEmployee.getEmail());
            this.employeeService.save(employee);
            return employee;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        Employee employee = this.employeeService.findById(id);
        if (employee != null) {
            this.employeeService.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }
}
