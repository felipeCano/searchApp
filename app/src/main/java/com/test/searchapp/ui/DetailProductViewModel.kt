package com.test.searchapp.ui

import com.test.searchapp.core.BaseViewModel
import com.test.searchapp.domain.repository.DetailRepository

class DetailProductViewModel  (private val seriesRepository: DetailRepository) : BaseViewModel() {

    fun getDetailsProduct(productId : String){
        addDisposableDetail(seriesRepository.detaiProductBd(productId))
    }
}