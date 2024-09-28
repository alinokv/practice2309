package com.web_project.shop.controllers;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result, Model model) { // Добавлен параметр курса
        if (result.hasErrors()){
            model.addAttribute("students", studentService.findAllStudents());
            return "studentList";
        }
        studentService.addStudent(student);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result, Model model) {
        //StudentModel updateStudent = new StudentModel(id, name, firstName, lastName, corpEmail, Course);
        studentService.updateStudent(student);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam long id) {
        studentService.deleteStudent(id); // Физическое удаление
        return "redirect:/students/all";
    }

    @PostMapping("/soft-delete")
    public String softDeleteStudent(@RequestParam long id) {
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
    public String getStudentId(@PathVariable("id") long id, Model model) {
        model.addAttribute("students", studentService.findStudentById(id));
        model.addAttribute("students", studentService.findAllStudents());
        return "studentList";
    }
}
