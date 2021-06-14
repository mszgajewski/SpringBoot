package com.example.SpringBoot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
           Student zaneta = new Student(

                    "Żaneta",
                    "zaneta@gmail.com",
                    LocalDate.of(1993, Month.APRIL,6)
            );
            Student maciek = new Student(
                    "Maciek",
                    "maciek@gmail.com",
                    LocalDate.of(1988, Month.FEBRUARY,3)
            );

            repository.saveAll(List.of(zaneta, maciek));
        };

    }
}
