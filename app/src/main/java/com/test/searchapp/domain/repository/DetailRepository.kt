package com.test.searchapp.domain.repository

import android.util.Log
import com.google.gson.Gson
import com.test.searchapp.data.api.ApiSearch
import com.test.searchapp.data.db.DetailProductDao
import com.test.searchapp.domain.modellocal.DetailProductModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DetailRepository (
    private val apiSearch: ApiSearch,
    private val detailProductDAo: DetailProductDao
) {

    fun detaiProductBd(productID : String) : Observable<DetailProductModel>{
        return getDetailProduct(productID).onErrorResumeNext(detailFromBd(productID))
    }

    fun getDetailProduct(serieId: String): Observable<DetailProductModel> {
        return apiSearch.getDetailProduct(serieId).map { response ->
            Gson().fromJson(response, DetailProductModel::class.java)
        }.doOnNext {
            saveProduct(it)
            Log.e("getDetailSeries", it.toString())
        }
            .doOnError {
                Log.e("getDetailSeries1", it.toString())
            }
    }

    fun saveProduct(productModel: DetailProductModel) {
        Observable.fromCallable { detailProductDAo.insertDetail(productModel) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }

    private fun detailFromBd(producId: String): Observable<DetailProductModel> {
        return detailProductDAo.detail(producId).filter { it != null }
            .toObservable()
            .doOnNext {
                Log.d("detailFromBd","Dispatching ${it.id} product from DB...")
            }
    }
}