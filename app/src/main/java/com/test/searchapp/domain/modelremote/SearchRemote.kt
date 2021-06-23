package com.test.searchapp.domain.modelremote

import com.test.searchapp.domain.modellocal.SearchLocal

data class SearchRemote(
    var results: List<SearchLocal> = emptyList()
)
