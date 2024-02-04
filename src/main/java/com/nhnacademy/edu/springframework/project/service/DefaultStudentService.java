package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.StudentService;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DefaultStudentService implements StudentService {

    Scores scoreRepository;
    Students studentRepository;

    public DefaultStudentService(Scores scoreRepository, Students studentRepository) {
        this.scoreRepository = scoreRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Collection<Student> getPassedStudents() {

        return studentRepository.findAll().stream()
                .filter(student -> student.getScore() != null && !student.getScore().isFail())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {

        return studentRepository.findAll().stream()
                    .filter(student -> student.getScore() != null)
                    .sorted(Comparator.comparingInt(student -> student.getScore().getScore()))
                    .collect(Collectors.toList());
    }

}
