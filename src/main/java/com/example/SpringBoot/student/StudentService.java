package com.example.SpringBoot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class StudentService {
    public List<Student> getStudents () {
        return List.of(
                new Student(
                        1L,
                        "Żaneta",
                        "zaneta.niesmiałek@gmail.com",
                        LocalDate.of(1993, Month.APRIL,6),
                        28
                )

        );
    }
}
