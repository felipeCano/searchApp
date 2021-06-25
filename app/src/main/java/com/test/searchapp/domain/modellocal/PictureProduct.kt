package com.test.searchapp.domain.modellocal

import androidx.room.PrimaryKey

data class PictureProduct(
    @PrimaryKey
    val product_id: Int,
    val thumbnail: String
)