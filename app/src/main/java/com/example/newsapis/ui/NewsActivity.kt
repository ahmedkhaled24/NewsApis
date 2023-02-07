package com.example.newsapis.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapis.R
import com.example.newsapis.dp.ArticleDatabase
import com.example.newsapis.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*
//cd57a8639a3844d19396d0c0f25a9625
class NewsActivity : AppCompatActivity() {

//    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

//        val newsRepository = NewsRepository(ArticleDatabase(this))
//        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
//        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}