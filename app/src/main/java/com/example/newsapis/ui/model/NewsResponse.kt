package com.example.newsapis.ui.model

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)