package com.example.spring_boot_mvc_project.repository;

import com.example.spring_boot_mvc_project.model.Course;

import java.util.List;

public interface CourseRepository {

    void saveCourse(Long id, Course course);

    void updateCourse(Long id,Course course);

    List<Course> getAllCourse(Long id);

    Course getCourseById(Long id);

    void deleteCourseById(Long id);
}