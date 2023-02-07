package com.example.newsapis.ui

import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.newsapis.dp.ArticleDatabase
import com.example.newsapis.repository.NewsRepository

open class BaseFragment(layout: Int) : Fragment(layout) {

    lateinit var viewModel: NewsViewModel

    fun initViewModel(){
        val newsRepository = NewsRepository(ArticleDatabase(requireActivity()))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
    }

    fun showProgressBar(view: ProgressBar) {
        view.visibility = View.VISIBLE
    }

    fun hideProgressBar(view: ProgressBar) {
        view.visibility = View.INVISIBLE
    }

    fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}

