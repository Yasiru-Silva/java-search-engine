package com.searchengine.indexer;

import java.util.HashMap;
import java.util.Map;

public class InvertedIndex {

    // Maps each word to a map of (fileName → word count in that file)
    private Map<String, Map<String, Integer>> index;

    // Constructor - creates an empty index
    public InvertedIndex() {
        index = new HashMap<>();
    }

    // Adds a word and the file it was found in to the index
    public void addWord(String word, String fileName) {

        // If word doesn't exist in index yet, create a new map for it
        if (!index.containsKey(word)) {
            index.put(word, new HashMap<>());
        }

        // Get the file map for this word
        Map<String, Integer> fileMap = index.get(word);

        // If file doesn't exist in map yet, start count at 0
        if (!fileMap.containsKey(fileName)) {
            fileMap.put(fileName, 0);
        }

        // Increment the word count for this file
        fileMap.put(fileName, fileMap.get(fileName) + 1);
    }

    // Returns map of (fileName → word count) for the given word
    public Map<String, Integer> search(String word) {

        if (index.containsKey(word)) {
            return index.get(word);
        }

        return new HashMap<>();
    }
}