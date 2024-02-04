package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradeQueryServiceTest {

    GradeQueryService gradeQueryService;
    Students students;
    Scores scores;


    @BeforeEach
    void setUP(){
        gradeQueryService = new DefaultGradeQueryService();
        students = CsvStudents.getInstance();
        scores = CsvScores.getInstance();

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