package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.config.MainConfig;
import com.nhnacademy.edu.springframework.project.service.Student;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringJUnitConfig(classes = {MainConfig.class})
class StudentsTest {

    @Autowired
    private CsvScores scoreReposiory;
    @Autowired
    private CsvStudents studentRepository;


    @Test
    @Order(1)
    void load() {
        studentRepository.load();
        Collection<Student> resultStudents = studentRepository.findAll();

        Assertions.assertFalse(resultStudents.isEmpty());
    }

    @Test
    @Order(2)
    void findAll() {
        Collection<Student> resultStudents = studentRepository.findAll();

        Assertions.assertNotNull(resultStudents);
        Assertions.assertEquals(4, resultStudents.size());
    }

    @Test
    @Order(3)
    void merge() {
        scoreReposiory.load();
        studentRepository.merge(scoreReposiory.findAll());

        Student studentWithScore = studentRepository.findAll().stream()
                .filter(student -> student.getSeq() == 3)
                .findFirst()
                .orElseThrow();

        Assertions.assertEquals(studentWithScore.getScore().getScore(), 70);
    }
}