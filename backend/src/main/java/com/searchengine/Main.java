package com.searchengine;

import com.searchengine.trie.Trie;
import java.util.List;
import com.searchengine.indexer.InvertedIndex;
import com.searchengine.fileparser.FileParser;
public class Main {

    public static void main(String[] args) {

        // Create the index and parser
        InvertedIndex invertedIndex = new InvertedIndex();
        FileParser fileParser = new FileParser(invertedIndex);

// Parse all files in the sample_docs folder
        fileParser.parseFolder("backend/data/sample_docs");

// Test search
        System.out.println("\nFiles containing 'java': " + invertedIndex.search("java"));
        System.out.println("Files containing 'programming': " + invertedIndex.search("programming"));
        System.out.println("Files containing 'python': " + invertedIndex.search("python"));
        System.out.println("Files containing 'ruby': " + invertedIndex.search("ruby"));

    }
}