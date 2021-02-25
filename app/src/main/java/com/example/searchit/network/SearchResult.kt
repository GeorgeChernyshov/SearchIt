package com.example.searchit.network

data class ResultPage (
    val kind: String,
    val url: ResultUrl,
    val queries: ResultQueries,
    val context: ResultContext,
    val searchInformation: SearchInformation,
    val items: List<SearchResult>)

data class ResultUrl (
    val type: String,
    val template: String)

data class ResultQueries (
    val request: List<ResultQuery>,
    val nextPage: List<ResultQuery>)

data class ResultQuery (
    val title: String,
    val totalResults: String,
    val searchTerms: String,
    val count: Int,
    val startIndex: Int,
    val inputEncoding: String,
    val outputEncoding: String,
    val safe: String,
    val cx: String)

data class ResultContext (val title: String)

data class SearchInformation (
    val searchTime: Double,
    val formattedSearchTime: String,
    val totalResults: String,
    val formattedTotalResults: String)

data class SearchResult (
    val kind: String,
    val title: String,
    val htmlTitle: String,
    val link: String,
    val displayLink: String,
    val snippet: String,
    val htmlSnippet: String,
    val cacheId: String?,
    val formattedUrl: String,
    val htmlFormattedUrl: String)