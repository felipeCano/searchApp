package com.test.searchapp.domain.modellocal

import androidx.room.Ignore

class ShortDescription() {
    var content: String? = ""

    @Ignore
    constructor(content: String) : this() {
        this.content = content
    }
}
