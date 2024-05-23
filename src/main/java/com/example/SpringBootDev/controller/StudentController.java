package com.example.SpringBootDev.controller;

import com.example.SpringBootDev.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/displayStudentForm")
    public String displayForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("countries", this.countries);
        model.addAttribute("languages", this.languages);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "student-confirmation";
    }
}
