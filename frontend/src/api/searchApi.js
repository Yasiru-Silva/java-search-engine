const BASE_URL = "http://localhost:8081/api"

// Calls the search endpoint and returns ranked results
export async function search(query) {
    const response = await fetch(`${BASE_URL}/search?query=${query}`)
    const data = await response.json()
    return data
}

// Calls the autocomplete endpoint and returns suggestions
export async function autocomplete(prefix) {
    const response = await fetch(`${BASE_URL}/autocomplete?prefix=${prefix}`)
    const data = await response.json()
    return data
}