package com.test.searchapp.ui

import com.test.searchapp.R
import com.test.searchapp.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment() {

    override fun onFinishedViewLoad() {
        tvHi.text = "Welcome  Skywalker"
    }

    override fun fragmentLayout(): Int = R.layout.fragment_search
}