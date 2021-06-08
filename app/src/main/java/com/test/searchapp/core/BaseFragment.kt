package com.test.searchapp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.test.searchapp.data.api.ApiSearch
import com.test.searchapp.data.db.SearchDao
import com.test.searchapp.data.db.SearchDataBase
import com.test.searchapp.util.Util
import okhttp3.OkHttpClient

abstract class BaseFragment : Fragment() {

    protected lateinit var okHttpClient: OkHttpClient
    protected lateinit var retrofit: ApiSearch
    protected lateinit var gosn: Gson
    protected lateinit var searchDao: SearchDao
    protected lateinit var searchDataBase: SearchDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(fragmentLayout(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gosn = Util.gsonProvider()
        okHttpClient = Util.okHttpClientProvider()
        retrofit = Util.retrofitProvider(okHttpClient, gosn)
       // searchDataBase = Util.dataBaseProvider(requireContext())
        onFinishedViewLoad()
    }

    @LayoutRes
    abstract fun fragmentLayout(): Int

    abstract fun onFinishedViewLoad()

    protected fun navController(): NavController? {
        return view?.let { Navigation.findNavController(it) }
    }
}