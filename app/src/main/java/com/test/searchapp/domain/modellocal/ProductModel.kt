package com.test.searchapp.domain.modellocal

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "ProductModel")
class ProductModel() {
    @PrimaryKey
    val product_id: String = ""
    @TypeConverters(ConvertPicture::class)
    var products: Array<PictureProduct> = emptyArray()
}