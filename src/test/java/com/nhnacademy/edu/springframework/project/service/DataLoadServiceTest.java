package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.config.MainConfig;
import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {MainConfig.class})
class DataLoadServiceTest {
    @Autowired
    CsvDataLoadService csvDataLoadService;
    @Autowired
    private CsvScores scoreReposiory;
    @Autowired
    private CsvStudents studentRepository;


    @Test
    void loadAndMerge() {

        csvDataLoadService.loadAndMerge();

        Collection<Student> mergedStudents = studentRepository.findAll();

        Collection<Score> mergedScores = scoreReposiory.findAll();

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