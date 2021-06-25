package com.test.searchapp.domain.modellocal

import androidx.room.PrimaryKey

class PictureProduct(
    @PrimaryKey
    var product_id: String,
    var thumbnail: String
)
