package com.test.searchapp.domain.repository

import android.util.Log
import com.google.gson.Gson
import com.test.searchapp.data.api.ApiSearch
import com.test.searchapp.data.db.SearchDao
import com.test.searchapp.domain.modellocal.SearchLocal
import com.test.searchapp.domain.modelremote.SearchRemote
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class SearchRepository(
    private val apiSearch: ApiSearch,
    private val searchDao: SearchDao
) {

    fun search() : Observable<List<SearchLocal>>{
        return getSearch().onErrorResumeNext(searchFromBd())
    }

    fun getSearch(): Observable<List<SearchLocal>> {
        return apiSearch.getSearch().map { response ->
            Log.d("getSearch", response.toString())
            Gson().fromJson(response, SearchRemote::class.java).results

        }.doOnNext {
            saveSearchs(it)
            Log.e("getSearch", it.toString())
        }
    }

    fun saveSearchs(searchLocal: List<SearchLocal>) {
        Observable.fromCallable { searchDao.insertSearchs(searchLocal) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnError {
                Log.e( "errorsave","Unable to search")
            }
            .doOnNext { Log.i("errorsave"," Found Search") }
            .subscribe()
    }

    private fun searchFromBd() :  Observable<List<SearchLocal>>{
        return searchDao.searchs().toObservable()
            .doOnNext{
                if (it.isNotEmpty()){
                    it
                }else{
                    Observable.just(emptyList<SearchLocal>())
                }
            }
    }
}