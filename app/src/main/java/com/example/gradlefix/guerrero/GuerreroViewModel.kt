package com.example.gradlefix.guerrero

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.gradlefix.model.Item
import com.example.gradlefix.netModule.RetrofitClient
import com.example.gradlefix.presentation.GuerreroPagingSource

class GuerreroViewModel: ViewModel() {

    val guerreros: LiveData<PagingData<Item>> = Pager(
        config = PagingConfig(
            pageSize = 5,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { GuerreroPagingSource(RetrofitClient.apiService) }
    ).liveData.cachedIn(viewModelScope)
}