package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.model.Student;

import java.util.List;
// import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student students);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student students);
    void deleteStudent(Long id);
}
