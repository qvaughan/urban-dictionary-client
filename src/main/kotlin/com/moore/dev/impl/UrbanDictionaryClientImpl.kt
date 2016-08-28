package com.moore.dev.impl

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mashape.unirest.http.Unirest
import com.moore.dev.Constants
import com.moore.dev.api.ShitBallsException
import com.moore.dev.api.UrbanDictionaryClient
import com.moore.dev.model.SearchResults
import java.io.IOException
import java.net.URLEncoder

/**
 * ryanmoore - 8/26/16.
 */
class UrbanDictionaryClientImpl(val mashapeApiKey: String) : UrbanDictionaryClient {

    override fun findDefinitions(searchTerm: String): SearchResults {

        //build headers
        val headers = mapOf(
                Pair("X-Mashape-Key", mashapeApiKey),
                Pair("Accept", "text/plain")
        )

        //make rest call
        val result: SearchResults
        val searchResult = Unirest.get(Constants.URBAN_DICTIONARY_URL + URLEncoder.encode(searchTerm, "UTF-8")).headers(headers).asString()
        if (searchResult != null && !searchResult.equals("")) {

            //create mapper
            val mapper = jacksonObjectMapper()
            try {
                //attempt mapping
                result = mapper.readValue(searchResult.body, SearchResults::class.java)
            } catch (ioException: IOException) {
                throw ShitBallsException(ioException)
            } catch (jsonParseException: JsonParseException) {
                throw ShitBallsException(jsonParseException)
            } catch (jacksonMappingException: JsonMappingException) {
                throw ShitBallsException(jacksonMappingException)
            }
        } else {
            throw ShitBallsException("Empty response from urban dictionary API.")
        }

        //things must have gone well to get here - lets sort by
        result.definitions?.sortedByDescending { it -> it.thumbsUp }

        return result
    }

}