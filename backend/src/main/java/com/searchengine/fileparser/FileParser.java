package com.searchengine.fileparser;

import com.searchengine.indexer.InvertedIndex;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileParser {

    // The index we will be adding words to
    private InvertedIndex invertedIndex;

    // Constructor - takes an InvertedIndex to fill
    public FileParser(InvertedIndex invertedIndex) {
        this.invertedIndex = invertedIndex;
    }

    // Reads all .txt files in a folder and adds their words to the index
    public void parseFolder(String folderPath) {

        // Create a File object from the folder path
        File folder = new File(folderPath);

        // Get all files in the folder
        File[] files = folder.listFiles();

        // If folder is empty or doesn't exist, stop
        if (files == null) {
            System.out.println("Folder not found: " + folderPath);
            return;
        }

        // Loop through each file in the folder
        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            // Only process .txt files
            if (file.getName().endsWith(".txt")) {
                parseFile(file);
            }
        }
    }

    // Reads a single file and adds its words to the index
    private void parseFile(File file) {

        try {
            // Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            // Read line by line until end of file
            while ((line = reader.readLine()) != null) {

                // Split the line into words by spaces
                String[] words = line.split(" ");

                // Add each word to the index
                for (int i = 0; i < words.length; i++) {

                    // Clean the word - lowercase and remove punctuation
                    String word = words[i].toLowerCase().replaceAll("[^a-z0-9]", "");

                    // Only add non empty words
                    if (!word.isEmpty()) {
                        invertedIndex.addWord(word, file.getName());
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