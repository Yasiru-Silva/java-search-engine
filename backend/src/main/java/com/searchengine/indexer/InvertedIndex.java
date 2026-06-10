package com.searchengine.indexer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {

    // The main index - maps each word to a set of files containing it
    // Key = word, Value = set of file names
    private Map<String, Set<String>> index;

    // Constructor - creates an empty index
    public InvertedIndex() {
        index = new HashMap<>();
    }

    // Adds a word and the file it was found in to the index
    public void addWord(String word, String fileName){

        // If this word doesn't exist in index yet, create a new set for it
        if (!index.containsKey(word)) {
            index.put(word, new HashSet<>());
        }

        // Add the file name to this word's set
        index.get(word).add(fileName);
    }

    // Returns all files that contain the given word
    public Set<String> search(String word){

        // If word exists return its files, otherwise return empty set
        if(index.containsKey(word)){
            return index.get(word);
        }

        return new HashSet<>();
    }
}
