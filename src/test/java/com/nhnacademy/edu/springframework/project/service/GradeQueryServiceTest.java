package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.config.MainConfig;
import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {MainConfig.class})
class GradeQueryServiceTest {
    @Autowired
    GradeQueryService gradeQueryService;
    @Autowired
    Students students;
    @Autowired
    Scores scores;


    @BeforeEach
    void setUP(){
    }

    @Test
    void getScoreByStudentName() {

        students.load();
        scores.load();

        List<Score> ScoresAList = gradeQueryService.getScoreByStudentName("A");
        List<Score> ScoresBList = gradeQueryService.getScoreByStudentName("B");

        assertEquals(2, ScoresAList.size());
        assertEquals(1, ScoresBList.size());
        assertEquals(ScoresAList.get(0).getScore(), 30);

    }

    @Test
    void getScoreByStudentSeq() {

        Score studentScore = gradeQueryService.getScoreByStudentSeq(3);

        assertNotNull(studentScore);
        assertEquals(studentScore.getScore(), 70);
    }

}