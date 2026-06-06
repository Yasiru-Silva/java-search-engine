package com.searchengine.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    // HashMap of letter → next node (children of this node)
    Map<Character, TrieNode> children;
    // true if a complete word ends at this node
    boolean isEndOfWord;

    public TrieNode() {

        // Create a brand new empty HashMap for this node
        // Every node starts with no children
        children = new HashMap<>();
        // Every new node starts as not the end of a word
        isEndOfWord = false;
    }
}
