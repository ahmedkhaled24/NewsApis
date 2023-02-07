package com.example.newsapis.repository

import com.example.newsapis.api.RetrofitInstance
import com.example.newsapis.dp.ArticleDatabase

class NewsRepository(val dp: ArticleDatabase) {
    suspend fun getBreakingNewsRepository(countryCode: String, pageNumber: Int) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearchNewsRepository(searchQuery: String, page: Int) = RetrofitInstance.api.searchForNews(searchQuery, page)

}