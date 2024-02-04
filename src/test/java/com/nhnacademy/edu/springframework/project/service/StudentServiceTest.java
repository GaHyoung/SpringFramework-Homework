package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.config.MainConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {MainConfig.class})
class StudentServiceTest {
    @Autowired
    DataLoadService dataLoadService;
    @Autowired
    DefaultStudentService studentService;

    @BeforeEach
    void setUp() {
        dataLoadService.loadAndMerge();
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

