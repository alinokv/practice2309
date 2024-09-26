package com.web_project.shop.controllers;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String corpEmail,
                             @RequestParam int course) { // Добавлен параметр курса
        StudentModel newStudent = new StudentModel(0, name, firstName, lastName, corpEmail, course);
        studentService.addStudent(newStudent);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String corpEmail,
                                @RequestParam int Course) { // Добавлен параметр курса
        StudentModel updateStudent = new StudentModel(id, name, firstName, lastName, corpEmail, Course);
        studentService.updateStudent(updateStudent);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id); // Физическое удаление
        return "redirect:/students/all";
    }

    @PostMapping("/soft-delete")
    public String softDeleteStudent(@RequestParam int id) {
        studentService.softDeleteStudent(id); // Логическое удаление
        return "redirect:/students/all";
    }

    @GetMapping("/filter")
    public String filterByCourse(@RequestParam int course, Model model) {
        model.addAttribute("students", studentService.findByCourse(course));
        return "studentList";
    }

    @GetMapping("/search")
    public String searchByParam(@RequestParam String param, Model model) {
        model.addAttribute("students", studentService.findByParam(param));
        return "studentList";
    }
    @GetMapping("/all/{id}")
    public String getStudentId(@PathVariable("id") int id, Model model) {
        model.addAttribute("students", studentService.findStudentById(id));
        return "studentList";
    }
}
