package com.web_project.shop.controllers;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("students", studentService.findAll());
            return "studentList";
        }
        studentService.add(student);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result) {
        studentService.update(student);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.delete(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getStudentById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("students", studentService.findById(id));
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

    @GetMapping("/search")
    public String searchStudentsByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("students", studentService.findByName(name));
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }
}
