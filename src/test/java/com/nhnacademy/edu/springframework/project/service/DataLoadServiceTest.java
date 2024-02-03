package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoadServiceTest {

    DataLoadService csvDataLoadService;

    @BeforeEach
    void setUP(){
        csvDataLoadService = new CsvDataLoadService();
    }

    @Test
    void loadAndMerge() {

        csvDataLoadService.loadAndMerge();

        Students students = CsvStudents.getInstance();
        Collection<Student> mergedStudents = students.findAll();

        Scores scores = CsvScores.getInstance();
        Collection<Score> mergedScores = scores.findAll();

        Student studentWithScore = mergedStudents.stream()
                .filter(student -> student.getSeq() == 3)
                .findFirst()
                .orElseThrow(AssertionError::new);

        Score expectedScore = mergedScores.stream()
                .filter(score -> score.getStudentSeq() == 3)
                .findFirst()
                .orElseThrow(AssertionError::new);

        assertEquals(expectedScore.getScore(), studentWithScore.getScore().getScore());


    }
}