package com.example.newsapis.repository

import com.example.newsapis.api.RetrofitInstance
import com.example.newsapis.dp.ArticleDatabase

class NewsRepository(val dp: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}