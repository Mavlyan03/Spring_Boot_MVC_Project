package com.example.spring_boot_mvc_project.service;

import com.example.spring_boot_mvc_project.model.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Long id, Student student);

    void updateStudent(Long id,Student student);

    List<Student> getAllStudents(Long id);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

    void assignStudentToCourse(Long studentId,Long courseId);
}
