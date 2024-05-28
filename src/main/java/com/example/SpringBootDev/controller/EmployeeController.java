package com.example.SpringBootDev.controller;

import com.example.SpringBootDev.entity.Employee;
import com.example.SpringBootDev.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = this.employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/employeeForm")
    public String displayForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    //Perform data binding for Employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        this.employeeService.save(employee);
        //Post/Redirect/Get pattern to prevent duplicate data submission
        return "redirect:/employees/list";
    }
}
