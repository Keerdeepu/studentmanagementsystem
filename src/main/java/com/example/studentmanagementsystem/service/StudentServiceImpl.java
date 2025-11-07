package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

     @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setStudent_name(student.getStudent_name());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhoneno(student.getPhoneno());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setSection(student.getSection());
        existingStudent.setAadharno(student.getAadharno());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
