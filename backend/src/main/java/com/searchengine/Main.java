package com.searchengine;

import com.searchengine.trie.Trie;
import java.util.List;
import com.searchengine.indexer.InvertedIndex;
public class Main {

    public static void main(String[] args) {

        // Create a new Trie
        Trie trie = new Trie();

        // Insert some words
        trie.insert("cat");
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("java");
        trie.insert("javascript");

        // Test search
        System.out.println("Search 'cat': " + trie.search("cat"));
        System.out.println("Search 'ca': " + trie.search("ca"));
        System.out.println("Search 'java': " + trie.search("java"));
        System.out.println("Search 'ruby': " + trie.search("ruby"));

        // Test autocomplete
        System.out.println("\nAutocomplete 'ca': " + trie.autocomplete("ca"));
        System.out.println("Autocomplete 'jav': " + trie.autocomplete("jav"));
        System.out.println("Autocomplete 'xyz': " + trie.autocomplete("xyz"));

        // Create an inverted index
        InvertedIndex invertedIndex = new InvertedIndex();

// Add some words and which files they appear in
        invertedIndex.addWord("java", "doc1.txt");
        invertedIndex.addWord("java", "doc2.txt");
        invertedIndex.addWord("programming", "doc1.txt");
        invertedIndex.addWord("programming", "doc3.txt");
        invertedIndex.addWord("python", "doc3.txt");

// Test search
        System.out.println("\nFiles containing 'java': " + invertedIndex.search("java"));
        System.out.println("Files containing 'programming': " + invertedIndex.search("programming"));
        System.out.println("Files containing 'ruby': " + invertedIndex.search("ruby"));

    }
}