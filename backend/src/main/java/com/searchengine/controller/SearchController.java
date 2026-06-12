package com.searchengine.controller;

import com.searchengine.fileparser.FileParser;
import com.searchengine.indexer.InvertedIndex;
import com.searchengine.ranking.Ranker;
import com.searchengine.trie.Trie;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SearchController {

    private InvertedIndex invertedIndex;
    private Ranker ranker;
    private Trie trie;

    // Constructor - initializes and indexes the sample docs on startup
    public SearchController() {
        this.invertedIndex = new InvertedIndex();
        this.ranker = new Ranker();
        this.trie = new Trie();

        // Index the sample docs folder
        FileParser fileParser = new FileParser(invertedIndex, trie);
        fileParser.parseFolder("data/sample_docs");
    }

    // Search endpoint - returns ranked results for a query
    // Example: GET /api/search?query=java
    @GetMapping("/search")
    public List<Ranker.Result> search(@RequestParam String query) {
        Map<String, Integer> fileScores = invertedIndex.search(query.toLowerCase());
        return ranker.rank(fileScores);
    }

    // Autocomplete endpoint - returns word suggestions for a prefix
    // Example: GET /api/autocomplete?prefix=jav
    @GetMapping("/autocomplete")
    public List<String> autocomplete(@RequestParam String prefix) {
        return trie.autocomplete(prefix.toLowerCase());
    }
}