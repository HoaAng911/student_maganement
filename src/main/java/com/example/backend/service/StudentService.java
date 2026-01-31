package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // GET all
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // GET by id
    public Student getStudentById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    // CREATE
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    // UPDATE
    public Student updateStudent(Integer id, Student updatedStudent) {
        Student student = getStudentById(id);
        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
        return repository.save(student);
    }

    // DELETE
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}
