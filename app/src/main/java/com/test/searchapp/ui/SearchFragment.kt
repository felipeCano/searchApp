package com.test.searchapp.ui

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import com.test.searchapp.R
import com.test.searchapp.core.BaseFragment
import com.test.searchapp.data.db.SearchDao
import com.test.searchapp.data.db.SearchDataBase
import com.test.searchapp.domain.modellocal.SearchLocal
import com.test.searchapp.domain.repository.SearchRepository
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : BaseFragment(), DetailSearchInterface {

    lateinit var searchViewModel: SearchViewModel
    lateinit var searchRepository: SearchRepository
    var mAdapter: SearchAdapter? = null
    var searchLocal: List<SearchLocal>? = null

    override fun onFinishedViewLoad() {
        searchDao = searchDao(searchDataBase)
        searchRepository = SearchRepository(retrofit, searchDao)
        searchViewModel = SearchViewModel(searchRepository)
        searchViewModel.getSeriesBd()

        searchViewModel.liveData.observe(this, recyclerSearch)

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                filter(editable.toString())
            }
        })
    }

    var recyclerSearch = Observer<List<SearchLocal>> { searchLocal ->
        mAdapter = SearchAdapter(searchLocal)
        mAdapter!!.onDetailsSearch(this)
        rvSearch.adapter = mAdapter
        this.searchLocal = searchLocal
    }

    private fun filter(text: String) {
        val filterdNames: ArrayList<SearchLocal> = ArrayList()

        for (s in searchLocal!!.toTypedArray()) {
            if (s.toString().toLowerCase().contains(text.toLowerCase())) {
                filterdNames.add(s)
            }

        }
        mAdapter!!.filterList(filterdNames)
    }

    override fun fragmentLayout(): Int = R.layout.fragment_search
    fun searchDao(db: SearchDataBase): SearchDao = db.seachDao()

    override fun onDetailsSearch(search: SearchLocal) {
    }
}