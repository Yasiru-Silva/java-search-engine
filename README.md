markdown# 🔍 Java Search Engine

A full-stack local file search engine built with Java and React. The engine indexes `.txt` files from a folder, allows full-text search, and returns results ranked by relevance.

---

## 🎯 Features

- 🔎 Full-text search across multiple `.txt` files
- 💡 Autocomplete suggestions using Trie data structure
- 📊 Results ranked by word frequency using a Min-Heap
- 🌐 REST API built with Spring Boot
- ⚛️ React frontend with real-time autocomplete
- ✅ Unit tested with JUnit 5
- 🔄 CI/CD pipeline with GitHub Actions

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Backend | Spring Boot 3.1.5 |
| Build Tool | Maven |
| Frontend | React + Vite |
| Styling | Tailwind CSS |
| Testing | JUnit 5 + Mockito |
| CI/CD | GitHub Actions |

---

## 📐 DSA Concepts Used

| Concept | Used For |
|---|---|
| Trie | Autocomplete / prefix search |
| HashMap | Inverted index (word → files) |
| HashSet | Avoid duplicate file names |
| Priority Queue (Heap) | Ranking results by score |
| DFS | Traversing Trie for suggestions |
| File I/O | Reading and parsing .txt files |

---

## 🏗️ Project Structure
java-search-engine/

├── backend/

│   ├── src/main/java/com/searchengine/

│   │   ├── trie/           → Trie + TrieNode

│   │   ├── indexer/        → InvertedIndex

│   │   ├── ranking/        → Ranker

│   │   ├── fileparser/     → FileParser

│   │   ├── controller/     → SearchController (REST API)

│   │   └── Main.java       → Spring Boot entry point

│   └── data/sample_docs/   → Sample .txt files

├── frontend/

│   └── src/

│       ├── components/     → SearchBar, SearchResults, Autocomplete

│       ├── api/            → searchApi.js

│       └── App.jsx

└── .github/workflows/      → GitHub Actions CI

---

## 🚀 How to Run

### Backend
```bash
cd backend
mvn spring-boot:run
```
API runs on `http://localhost:8081`

### Frontend
```bash
cd frontend
npm run dev
```
UI runs on `http://localhost:5173`

---

## 🔌 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/search?query=java` | Search files by keyword |
| GET | `/api/autocomplete?prefix=jav` | Get autocomplete suggestions |

---

## 👤 Author

**Yasiru Silva**
- GitHub: [@Yasiru-Silva](https://github.com/Yasiru-Silva)