package com.test.searchapp.ui

import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import com.test.searchapp.R
import com.test.searchapp.core.BaseFragment
import com.test.searchapp.data.db.DetailProductDao
import com.test.searchapp.data.db.SearchDataBase
import com.test.searchapp.domain.modellocal.DetailProductModel
import com.test.searchapp.domain.repository.DetailRepository
import kotlinx.android.synthetic.main.fragment_detail_product.*

class DetailProductFragment  : BaseFragment() {

    lateinit var detailRepository: DetailRepository
    lateinit var detailProductViewModel: DetailProductViewModel
    var productId : String = ""

    override fun onFinishedViewLoad() {
        productId = requireArguments().getString("productId", productId)
        initializeUi()
    }

    private fun initializeUi() {
        detailDao =detailDao(searchDataBase)
        detailRepository = DetailRepository(retrofit, detailDao)
        detailProductViewModel = DetailProductViewModel(detailRepository)
        detailProductViewModel.getDetailsProduct(productId)

        detailProductViewModel.liveDataDetail.observe(this, viewDetails)

    }

    fun initViewDetailSerie(detailProductModel: DetailProductModel){
        titleDetail.text = detailProductModel.name
        overrideDetail.text = detailProductModel.short_description!!.content
      /*  Picasso.get()
            .load( detailProductModel.pickers[0].thumbnail)
            .resize(600, 800)
            .centerCrop()
            .into(imageDetail)*/
    }

    var viewDetails = Observer<DetailProductModel> { detailProductModel ->
        initViewDetailSerie(detailProductModel)
    }

    override fun fragmentLayout(): Int = R.layout.fragment_detail_product

    fun detailDao(db: SearchDataBase): DetailProductDao = db.detailDao()
}