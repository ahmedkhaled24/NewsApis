package com.example.newsapis.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapis.R
import com.example.newsapis.adapters.NewsAdapter
import com.example.newsapis.ui.BaseFragment
import com.example.newsapis.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import kotlinx.android.synthetic.main.fragment_breaking_news.paginationProgressBar

class BreakingNewsFragment : BaseFragment(R.layout.fragment_breaking_news){

    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        setUpRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    hideProgressBar(paginationProgressBar)
                    it.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }

                is Resource.Error -> {
                    hideProgressBar(paginationProgressBar)
                    it.message?.let { error->
                        showToast(error)
                    }
                }

                is Resource.Loading -> {
                    showProgressBar(paginationProgressBar)
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}
