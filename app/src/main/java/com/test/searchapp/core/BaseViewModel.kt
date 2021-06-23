package com.test.searchapp.core

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.searchapp.domain.modellocal.SearchLocal
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    val liveData = MutableLiveData<List<SearchLocal>>()
    private val disposables = CompositeDisposable()

    protected fun  addDisposable(observable: Observable<List<SearchLocal>>){
        val disposables1 : Disposable = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
            }
            .subscribe ({
                liveData.postValue(it)
            },{
                Log.d("holi","holi2")
            })
        disposables.add(
            disposables1
        )
    }


    override fun onCleared() {
        disposables.clear()
    }
}