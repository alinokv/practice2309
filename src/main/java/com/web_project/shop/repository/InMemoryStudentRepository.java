package com.web_project.shop.repository;
import com.web_project.shop.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Repository
public class InMemoryStudentRepository {
    private List<StudentModel> students = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<StudentModel> findAllStudents() {
        return students.stream().filter(student -> !student.isDeleted()).collect(Collectors.toList());
    }

    public StudentModel addStudent(StudentModel student) {
        student.setId(idCounter.getAndIncrement());
        students.add(student);
        return student;
    }

    public StudentModel updateStudent(StudentModel student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()){
                students.set(i, student);
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id); // Физическое удаление
    }

    public void softDeleteStudent(int id) {
        students.stream().filter(student -> student.getId() == id).forEach(student -> student.setDeleted(true)); // Логическое удаление
    }

    public StudentModel findStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id )
                .findFirst()
                .orElse(null);
    }

    public List<StudentModel> findByCourse(int course) {
        return students.stream()
                .filter(student -> student.getCourse() == course && !student.isDeleted()) // Поиск по курсу и не удалённые
                .collect(Collectors.toList());
    }

    public List<StudentModel> findByParam(String param) {
        return students.stream()
                .filter(student -> (student.getName().equalsIgnoreCase(param)
                        || student.getFirstName().equalsIgnoreCase(param)
                        || (student.getLastName() != null && student.getLastName().equalsIgnoreCase(param)))
                        && !student.isDeleted()) // Поиск по параметрам, исключая удалённых
                .collect(Collectors.toList());
    }
}

