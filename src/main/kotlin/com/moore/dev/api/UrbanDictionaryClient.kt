package com.moore.dev.api

import com.moore.dev.model.SearchResults

/**
 * ryanmoore - 8/26/16.
 */
interface UrbanDictionaryClient {

    @Throws(ShitBallsException::class)
    fun findDefinitions(searchTerm: String): SearchResults
}