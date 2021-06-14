package com.example.SpringBoot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    public final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents () {
        return studentRepository.findAll();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        Optional <Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
    throw new IllegalStateException("Email zajęty");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException(
                    "student o id " +studentId + " nie istnieje");
        }
        studentRepository.deleteById(studentId);
    }
}
