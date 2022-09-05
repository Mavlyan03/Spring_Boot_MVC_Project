package com.example.spring_boot_mvc_project.api;

import com.example.spring_boot_mvc_project.model.Course;
import com.example.spring_boot_mvc_project.model.Student;
import com.example.spring_boot_mvc_project.service.CourseService;
import com.example.spring_boot_mvc_project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/allStudents/{companyId}")
    private String getAllStudents(@PathVariable("companyId")Long companyId, Model model,@ModelAttribute("course")Course course) {
        model.addAttribute("allStudents", studentService.getAllStudents(companyId));
        model.addAttribute("companyId",companyId);
        model.addAttribute("courses", courseService.getAllCourse(companyId));
        return "student/mainStudent";
    }

    @GetMapping("/{companyId}/newStudent")
    private String newStudent(@PathVariable("companyId")Long id, Model model) {
        model.addAttribute("newStudent", new Student());
        model.addAttribute("companyId",id);
        return "student/newStudent";
    }

    @PostMapping("{companyId}/saveStudent")
    private String saveStudent(@PathVariable("companyId") Long companyId, @ModelAttribute("newStudent") Student student) {
        studentService.saveStudent(companyId, student);
        return "redirect:/students/allStudents/ "+companyId;
    }

    @GetMapping("/getStudent/{id}")
    private String getStudentById(@PathVariable("id") Long id,Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "student/mainStudent";
    }

    @GetMapping("/update/{studentId}")
    private String updateStudent(@PathVariable("studentId")Long id,Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        model.addAttribute("companyId",student.getCompany().getCompanyId());
        return "student/updateStudent";
    }

    @PostMapping("/{companyId}/{studentId}/saveUpdateStudent")
    public String saveUpdateStudent(@PathVariable("companyId") Long id,
                                    @PathVariable("studentId")Long studentId,
                                    @ModelAttribute("student") Student student) {
        studentService.updateStudent(studentId,student);
        return "redirect:/students/allStudents/ "+id;
    }

    @PostMapping("/{studentId}/{companyId}/delete")
    private String deleteStudent(@PathVariable("studentId")Long id,@PathVariable("companyId") Long companyId) {
        studentService.deleteStudentById(id);
        return "redirect:/students/allStudents/ "+companyId;
    }

    @PostMapping("/{companyId}/{studentId}/assign")
    private String assign(@PathVariable("studentId")Long id,
                          @PathVariable("companyId")Long companyId,
                          @ModelAttribute("course") Course course) {
        studentService.assignStudentToCourse(id,course.getCourseId());
        return "redirect:/students/allStudents/ "+ companyId;
    }

}