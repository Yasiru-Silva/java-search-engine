package com.searchengine.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    // The starting point of the Trie - every search begins from here
    // It doesn't hold any letter itself, just the entry point
    private final TrieNode root;

    // Constructor - creates the Trie with an empty root node
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie letter by letter
    public void insert(String word) {

        // Start from the root node
        TrieNode current = root;

        // Loop through each letter in the word using index
        for (int i = 0; i < word.length(); i++) {

            // Get the current letter
            char ch = word.charAt(i);

            // If this letter doesn't exist in current node's children, add it
            current.children.putIfAbsent(ch, new TrieNode());

            // Move to the next node
            current = current.children.get(ch);
        }

        // Mark the last node as end of word
        current.isEndOfWord = true;
    }

    public boolean search(String word) {

        // Start from the root node
        TrieNode current = root;

        // Loop through each letter in the word
        for (int i = 0; i < word.length(); i++) {

            // Get the current letter
            char ch = word.charAt(i);

            // If letter doesn't exist in current node's children, word not found
            if (!current.children.containsKey(ch)) {
                return false;
            }

            // Move to the next node
            current = current.children.get(ch);
        }

        // After loop, check if this is actually a complete word
        return current.isEndOfWord;
    }

    public List<String> autocomplete(String prefix) {

        // List to store all the suggestions
        List<String> results = new ArrayList<>();

        // Start from root
        TrieNode current = root;

        // Navigate to the end of the prefix
        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            // If prefix doesn't exist in Trie, return empty list
            if (!current.children.containsKey(ch)) {
                return results;
            }

            // Move to next node
            current = current.children.get(ch);
        }

        // From the end of prefix, collect all words below
        dfs(current, prefix, results);

        return results;
    }

    private void dfs(TrieNode node, String currentWord, List<String> results) {

        // If this node is the end of a word, add it to results
        if (node.isEndOfWord) {
            results.add(currentWord);
        }

        // Go through each child node
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);

            if (node.children.containsKey(ch)) {
                dfs(node.children.get(ch), currentWord + ch, results);
            }
        }
    }
}