package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Student;
import com.example.backend.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // 1. GET /api/students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // 2. GET /api/students/{id}
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    // 3. POST /api/students
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // 4. PUT /api/students/{id}
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // 5. DELETE /api/students/{id}
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "Deleted student with id " + id;
    }
}
