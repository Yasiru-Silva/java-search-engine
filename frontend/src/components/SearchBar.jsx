function SearchBar({ query, onQueryChange, onSearch }) {
    return (
        <div className="flex gap-2">
            <input
                type="text"
                value={query}
                onChange={(e) => onQueryChange(e.target.value)}
                placeholder="Search files..."
                className="flex-1 px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:border-blue-500"
            />
            <button
                onClick={onSearch}
                className="px-6 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
            >
                Search
            </button>
        </div>
    )
}

export default SearchBar