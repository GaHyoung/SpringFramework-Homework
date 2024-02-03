package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.junit.jupiter.api.*;

import java.util.Collection;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentsTest {

    CsvStudents csvStudents;
    CsvScores csvScores;

    @BeforeEach
    void setUp() {
        csvStudents = (CsvStudents) CsvStudents.getInstance();

    }

    @Test
    @Order(1)
    void load() {
        csvStudents.load();
        Collection<Student> resultStudents = csvStudents.findAll();

        Assertions.assertFalse(resultStudents.isEmpty());
    }

    @Test
    @Order(2)
    void findAll() {
        Collection<Student> resultStudents = csvStudents.findAll();

        Assertions.assertEquals(4, resultStudents.size());
    }

    @Test
    @Order(3)
    void merge() {
        csvScores = (CsvScores) CsvScores.getInstance();
        csvScores.load();
        csvStudents.merge(csvScores.findAll());

        Student studentWithScore = csvStudents.findAll().stream()
                .filter(student -> student.getSeq() == 3)
                .findFirst()
                .orElseThrow();

        Assertions.assertEquals(studentWithScore.getScore().getScore(), 70);
    }
}