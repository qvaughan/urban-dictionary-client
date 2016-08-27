package com.moore.dev.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * ryanmoore - 8/26/16.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class SearchResultDetails(
        @JsonProperty("definition") var definition: String?,
        @JsonProperty("permalink") var permalink: String?,
        @JsonProperty("thumbs_up") var thumbsUp: Long?,
        @JsonProperty("thumbs_down") var thumbsDown: Long?,
        @JsonProperty("author") var author: String?,
        @JsonProperty("word") var word: String?,
        @JsonProperty("defid") var definitionId: String?,
        @JsonProperty("current_vote") var currentVote: String?,
        @JsonProperty("example") var example: String?
)