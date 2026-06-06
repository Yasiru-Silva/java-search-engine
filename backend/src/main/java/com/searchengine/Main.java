package com.searchengine;

import com.searchengine.trie.Trie;
import java.util.List;

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
    }
}