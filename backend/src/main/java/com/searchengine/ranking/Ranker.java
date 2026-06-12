package com.searchengine.ranking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Ranker {

    // Represents a single search result with a file name and score
    public static class Result {
        String fileName;
        int score;

        public Result(String fileName, int score) {
            this.fileName = fileName;
            this.score = score;
        }

        // Getters - needed for Spring Boot to convert to JSON
        public String getFileName() {
            return fileName;
        }

        public int getScore() {
            return score;
        }

        public String toString() {
            return fileName + " (score: " + score + ")";
        }
    }

    // Takes a map of (fileName → score) and returns a ranked list
    public List<Result> rank(Map<String, Integer> fileScores) {

        // PriorityQueue that sorts by highest score first
        PriorityQueue<Result> heap = new PriorityQueue<>(
                (a, b) -> b.score - a.score
        );

        // Add all results to the heap
        for (String fileName : fileScores.keySet()) {
            heap.add(new Result(fileName, fileScores.get(fileName)));
        }

        // Pull results out of heap in ranked order
        List<Result> ranked = new ArrayList<>();
        while (!heap.isEmpty()) {
            ranked.add(heap.poll());
        }

        return ranked;
    }
}