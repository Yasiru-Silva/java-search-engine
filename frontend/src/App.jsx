import { useState } from "react"
import SearchBar from "./components/SearchBar"
import SearchResults from "./components/SearchResults"
import Autocomplete from "./components/Autocomplete"
import { search, autocomplete } from "./api/searchApi"

function App() {

    // State variables
    const [query, setQuery] = useState("")
    const [results, setResults] = useState([])
    const [suggestions, setSuggestions] = useState([])

    // Runs when user types in the search bar
    async function handleQueryChange(value) {
        setQuery(value)

        // Get autocomplete suggestions if user typed something
        if (value.length > 0) {
            const data = await autocomplete(value)
            setSuggestions(data)
        } else {
            setSuggestions([])
        }
    }

    // Runs when user clicks Search button
    async function handleSearch() {
        if (query.length === 0) return
        const data = await search(query)
        setResults(data)
        setSuggestions([])
    }

    // Runs when user clicks an autocomplete suggestion
    function handleSuggestionClick(suggestion) {
        setQuery(suggestion)
        setSuggestions([])
    }

    return (
        <div className="min-h-screen bg-gray-100 flex flex-col items-center pt-20 px-4">

            {/* Title */}
            <h1 className="text-3xl font-bold text-blue-600 mb-8">
                Java Search Engine
            </h1>

            {/* Search area */}
            <div className="w-full max-w-2xl">

                {/* Search bar */}
                <SearchBar
                    query={query}
                    onQueryChange={handleQueryChange}
                    onSearch={handleSearch}
                />

                {/* Autocomplete suggestions */}
                <Autocomplete
                    suggestions={suggestions}
                    onSuggestionClick={handleSuggestionClick}
                />

                {/* Search results */}
                <SearchResults results={results} />

            </div>
        </div>
    )
}

export default App