package com.nhnacademy.edu.springframework.project.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvScores implements Scores {

    private static CsvScores csvScoresInstance;
    private static final List<Score> scores = new ArrayList<>();

    private static final String resourecsPath = "data/score.csv";
    private CsvScores(){}


    public static Scores getInstance() {

        if(csvScoresInstance == null){
            csvScoresInstance = new CsvScores();
        }
        return csvScoresInstance;
    }

    @Override
    public void load() {
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourecsPath)));
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
