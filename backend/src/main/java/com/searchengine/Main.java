package com.searchengine;

import com.searchengine.trie.Trie;
import java.util.List;
import com.searchengine.indexer.InvertedIndex;
import com.searchengine.fileparser.FileParser;
import com.searchengine.ranking.Ranker;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create the index, parser and ranker
        InvertedIndex invertedIndex = new InvertedIndex();
        FileParser fileParser = new FileParser(invertedIndex);
        Ranker ranker = new Ranker();

// Parse all files in the sample_docs folder
        fileParser.parseFolder("backend/data/sample_docs");

// Search and rank results
        System.out.println("\nSearch results for 'java':");
        List<Ranker.Result> results = ranker.rank(invertedIndex.search("java"));
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }

        System.out.println("\nSearch results for 'programming':");
        List<Ranker.Result> results2 = ranker.rank(invertedIndex.search("programming"));
        for (int i = 0; i < results2.size(); i++) {
            System.out.println((i + 1) + ". " + results2.get(i));
        }


    }
}