package com.searchengine.fileparser;

import com.searchengine.indexer.InvertedIndex;
import com.searchengine.trie.Trie;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileParser {

    // The index we will be adding words to
    private InvertedIndex invertedIndex;

    // The trie we will be adding words to for autocomplete
    private Trie trie;

    // Constructor - takes an InvertedIndex and Trie to fill
    public FileParser(InvertedIndex invertedIndex, Trie trie) {
        this.invertedIndex = invertedIndex;
        this.trie = trie;
    }

    // Reads all .txt files in a folder and adds their words to the index
    public void parseFolder(String folderPath) {

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Folder not found: " + folderPath);
            return;
        }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.getName().endsWith(".txt")) {
                parseFile(file);
            }
        }
    }

    // Reads a single file and adds its words to the index and trie
    private void parseFile(File file) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {

                String[] words = line.split(" ");

                for (int i = 0; i < words.length; i++) {

                    // Clean the word
                    String word = words[i].toLowerCase().replaceAll("[^a-z0-9]", "");

                    if (!word.isEmpty()) {
                        // Add to inverted index
                        invertedIndex.addWord(word, file.getName());
                        // Add to trie for autocomplete
                        trie.insert(word);
                    }
                }
            }

            reader.close();
            System.out.println("Indexed: " + file.getName());

        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}