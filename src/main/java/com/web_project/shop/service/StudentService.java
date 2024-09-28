package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;

import java.util.List;


public interface StudentService {
    public List<StudentModel> findAllStudents();

    public StudentModel findStudentById(long id);

    public StudentModel addStudent(StudentModel student);

    public StudentModel updateStudent(StudentModel student);

    void deleteStudent(long id); // Физическое удаление
    void softDeleteStudent(long id); // Логическое удаление
    List<StudentModel> findByCourse(int course); // Фильтрация по курсу
    List<StudentModel> findByParam(String param); // Поиск по параметрам (кроме id)


}
