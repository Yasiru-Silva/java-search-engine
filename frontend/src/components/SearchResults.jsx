// Takes a list of search results and displays them
function SearchResults({ results }) {

    // If no results found, show a message
    if (results.length === 0) {
        return <p className="text-gray-500 text-center mt-4">No results found.</p>
    }

    return (
        <div className="mt-4 flex flex-col gap-2">

            {/* Loop through each result and display it as a card */}
            {results.map((result, index) => (
                <div
                    key={index}
                    className="bg-white px-4 py-3 rounded-lg shadow flex justify-between items-center"
                >
                    {/* File name on the left */}
                    <span className="font-medium text-gray-700">{result.fileName}</span>

                    {/* Score on the right */}
                    <span className="text-blue-600 font-bold">Score: {result.score}</span>
                </div>
            ))}

        </div>
    )
}

export default SearchResults