package com.nhnacademy.edu.springframework.project.repository;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ScoresTest {

    CsvScores csvScores;

    @BeforeEach
    void setUp() {
        csvScores = (CsvScores) CsvScores.getInstance();
    }

    @Test
    @Order(1)
    void load(){
        csvScores.load();
        List<Score> resultScores = csvScores.findAll();

        Assertions.assertFalse(resultScores.isEmpty());
    }

    @Test
    @Order(2)
    void findAll(){
        List<Score> scores = csvScores.findAll();

        assertEquals(3, scores.size());
    }
}


