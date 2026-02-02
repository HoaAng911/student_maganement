package com.example.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {
  List<Student>findByName(String name);
}
