package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CsvStudents implements Students {

    private static final List<Student> students = new ArrayList<>();
    private static final String resourecesPath = "data/student.csv";


    @Override
    public void load() {
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourecesPath)));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int seq = Integer.parseInt(data[0]);
                String name = data[1];
                students.add(new Student(seq, name));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Collection<Student> findAll() {
        return students;
    }

    @Override
    public void merge(Collection<Score> scores) {
        scores.forEach(score -> {
            students.stream()
                    .filter(student -> student.getSeq() == score.getStudentSeq())
                    .findFirst()
                    .ifPresent(student -> student.setScore(score));
        });
    }
}
