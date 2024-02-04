package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.config.MainConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringJUnitConfig(classes = {MainConfig.class})
class ScoresTest {

    @Autowired
    private CsvScores scoreReposiory;

    @Test
    @Order(1)
    void load(){
        scoreReposiory.load();
        List<Score> resultScores = scoreReposiory.findAll();

        Assertions.assertFalse(resultScores.isEmpty());
    }

    @Test
    @Order(2)
    void findAll(){
        List<Score> scores = scoreReposiory.findAll();

        assertEquals(3, scores.size());
    }
}


