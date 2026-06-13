// Shows autocomplete suggestions below the search bar
function Autocomplete({ suggestions, onSuggestionClick }) {

    // If no suggestions, show nothing
    if (suggestions.length === 0) {
        return null
    }

    return (
        <div className="bg-white border border-gray-200 rounded-lg shadow mt-1">

            {/* Loop through each suggestion and display it */}
            {suggestions.map((suggestion, index) => (
                <div
                    key={index}
                    onClick={() => onSuggestionClick(suggestion)}
                    className="px-4 py-2 hover:bg-blue-50 cursor-pointer text-gray-700"
                >
                    {suggestion}
                </div>
            ))}

        </div>
    )
}

export default Autocomplete