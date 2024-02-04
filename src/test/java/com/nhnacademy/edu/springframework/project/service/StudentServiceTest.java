package com.nhnacademy.edu.springframework.project.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    DataLoadService dataLoadService;
    DefaultStudentService studentService;

    @BeforeEach
    void setUp() {
        dataLoadService = new CsvDataLoadService();
        dataLoadService.loadAndMerge();
        studentService = new DefaultStudentService();
    }

    @Test
    void getPassedStudents() {
        Collection<Student> passedStudents = studentService.getPassedStudents();

        assertEquals(2, passedStudents.size());
    }

    @Test
    void getStudentsOrderByScore() {
        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();

        assertEquals(orderedStudents.size(), 3);
    }
}

