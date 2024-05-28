package com.example.SpringBootDev.controller;

import com.example.SpringBootDev.entity.Employee;
import com.example.SpringBootDev.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        //Prepopulate the form
        Employee employee = this.employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        this.employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
