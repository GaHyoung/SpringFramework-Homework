package com.nhnacademy.edu.springframework.project.repository;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CsvScores implements Scores {

    private static final List<Score> scores = new ArrayList<>();

    private static final String resourecesPath = "data/score.csv";

    @Override
    public void load() {
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourecesPath)));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int seq = Integer.parseInt(data[0]);
                int score = Integer.parseInt(data[1]);
                scores.add(new Score(seq, score));
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
    public List<Score> findAll() {
        return scores;
    }
}
