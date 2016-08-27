package com.moore.dev.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * ryanmoore - 6/3/16.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class SearchResults(
        @JsonProperty("list") var items: List<SearchResultDetails>?,
        @JsonProperty("tags") var tags: List<String>,
        @JsonProperty("result_type") var resultType: String?,
        @JsonProperty("sounds") var sounds: List<String>?
)