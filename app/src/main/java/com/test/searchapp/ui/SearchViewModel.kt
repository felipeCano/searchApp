package com.test.searchapp.ui

import com.test.searchapp.core.BaseViewModel
import com.test.searchapp.domain.repository.SearchRepository

class SearchViewModel(private val searchRepository: SearchRepository) : BaseViewModel() {

    fun getSeriesBd(){
        addDisposable(searchRepository.search())
    }

    fun clearDisposable(){
        clearDisposable()
    }
}