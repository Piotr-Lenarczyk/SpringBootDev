package com.example.SpringBootDev.rest;

import com.example.SpringBootDev.entity.Instructor;
import com.example.SpringBootDev.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorRestController {
    private final InstructorService instructorService;

    public InstructorRestController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public List<Instructor> retrieveAllInstructors() {
        return this.instructorService.findAll();
    }

    @GetMapping("/instructors/{id}")
    public Instructor retrieveInstructor(@PathVariable int id) {
        Instructor instructor = this.instructorService.findById(id);
        if (instructor != null) {
            return instructor;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return this.instructorService.save(instructor);
    }

    @PutMapping("/instructors/{id}")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return this.instructorService.save(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public void deleteInstructor(@PathVariable int id) {
        Instructor instructor = this.instructorService.findById(id);
        if (instructor != null) {
            this.instructorService.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }
}
