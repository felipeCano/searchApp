package com.test.searchapp.domain.modellocal

import androidx.room.*


@Entity(tableName = "DetailProductModel", indices = [Index(value = ["id"], unique = true)])
data class DetailProductModel( @PrimaryKey var id: String) {
    var name: String? = null
  /*  @TypeConverters(ConverterPickers::class)
    var pickers: List<PictureProduct> = emptyList()*/
    @Embedded
    var short_description : ShortDescription? = null


}
