package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultGradeQueryService implements GradeQueryService {

    @Override
    public List<Score> getScoreByStudentName(String name) {

        Students studentRepository = CsvStudents.getInstance();

        List<Integer> seqList = studentRepository.findAll().stream()
                .filter(student -> student.getName().equals(name))
                .map(Student::getSeq)
                .collect(Collectors.toList());

        Scores scores = CsvScores.getInstance();

        List<Score> scoreList = scores.findAll();
        return scoreList.stream()
                .filter(score -> seqList.contains(score.getStudentSeq()))
                .collect(Collectors.toList());
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {

        Scores scores = CsvScores.getInstance();
        List<Score> scoreList = scores.findAll();

        return scoreList.stream()
                .filter(score -> score.getStudentSeq() == seq)
                .findFirst()
                .orElse(null);

    }
}
