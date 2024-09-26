package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;

import java.util.List;


public interface StudentService {
    public List<StudentModel> findAllStudents();

    public StudentModel findStudentById(int id);

    public StudentModel addStudent(StudentModel student);

    public StudentModel updateStudent(StudentModel student);

    void deleteStudent(int id); // Физическое удаление
    void softDeleteStudent(int id); // Логическое удаление
    List<StudentModel> findByCourse(int course); // Фильтрация по курсу
    List<StudentModel> findByParam(String param); // Поиск по параметрам (кроме id)


}
