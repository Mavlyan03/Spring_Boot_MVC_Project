package com.example.spring_boot_mvc_project.service;
import com.example.spring_boot_mvc_project.model.Instructor;

import java.util.List;

public interface InstructorService {

    void saveInstructor(Long id, Instructor instructor);

    void updateInstructor(Long id,Instructor instructor);

    List<Instructor> getAllInstructor(Long id);

    Instructor getInstructorById(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long instructorId,Long courseId);

}