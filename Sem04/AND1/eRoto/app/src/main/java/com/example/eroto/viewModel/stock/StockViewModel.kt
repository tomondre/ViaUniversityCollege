package com.example.eroto.viewModel.stock

import androidx.lifecycle.LiveData
import com.example.eroto.models.Post
import com.example.eroto.models.PostList
import com.example.eroto.models.Stock

interface StockViewModel {
    fun getStockByTicker(ticker: String): Stock
    fun getStockPosts(ticker: String): LiveData<List<Post>>
}