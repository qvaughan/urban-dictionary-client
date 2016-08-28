package com.moore.dev.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

/**
 * ryanmoore - 6/3/16.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class SearchResults(
        //using arraylists so we can sort more easily
        @JsonProperty("list") var definitions: ArrayList<SearchResultDetails>?,
        @JsonProperty("tags") var tags: ArrayList<String>,
        @JsonProperty("result_type") var resultType: String?,
        @JsonProperty("sounds") var sounds: ArrayList<String>?
)