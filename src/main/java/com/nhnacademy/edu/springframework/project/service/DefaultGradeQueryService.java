package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultGradeQueryService implements GradeQueryService {
     Scores scoreRepository;
     Students studentRepository;

    public DefaultGradeQueryService(Scores scoreRepository, Students studentRepository) {
        this.scoreRepository = scoreRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Score> getScoreByStudentName(String name) {

        List<Integer> seqList = studentRepository.findAll().stream()
                .filter(student -> student.getName().equals(name))
                .map(Student::getSeq)
                .collect(Collectors.toList());

        List<Score> scoreList = scoreRepository.findAll();

        return scoreList.stream()
                .filter(score -> seqList.contains(score.getStudentSeq()))
                .collect(Collectors.toList());
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {

        List<Score> scoreList = scoreRepository.findAll();

        return scoreList.stream()
                .filter(score -> score.getStudentSeq() == seq)
                .findFirst()
                .orElse(null);

    }
}
