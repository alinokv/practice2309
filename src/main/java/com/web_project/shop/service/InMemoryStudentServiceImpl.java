package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.repository.StudentRepository;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public InMemoryStudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel findStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentModel addStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(long id) {

        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
    }

    @Override
    public void softDeleteStudent(long id) {

    }

    @Override
    public List<StudentModel> findByCourse(int course) {
        return List.of();
    }

    @Override
    public List<StudentModel> findByParam(String param) {
        return List.of();
    }

//    @Override
//    public void softDeleteStudent(int id) {
//        studentRepository.softDeleteStudent(id); // Логическое удаление
//    }
//
//    @Override
//    public List<StudentModel> findByCourse(int course) {
//        return studentRepository.findByCourse(course); // Поиск по курсу
//    }
//
//    @Override
//    public List<StudentModel> findByParam(String param) {
//        return studentRepository.findByParam(param); // Поиск по параметрам
//    }

}
