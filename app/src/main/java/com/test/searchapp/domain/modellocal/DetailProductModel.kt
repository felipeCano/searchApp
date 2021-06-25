package com.test.searchapp.domain.modellocal

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*
import com.google.gson.annotations.JsonAdapter

//@JsonAdapter(ProductsDetailDesarilizador::class)
@Entity(tableName = "DetailProductModel", indices = [Index(value = ["id"], unique = true)])
class DetailProductModel()  {
    @PrimaryKey
    var id: String = ""
    var name: String? = null
   // @TypeConverters(ConverterPickers::class)
    //var pickers: Array<ProductModel> = emptyArray()
    @Embedded
    var short_description : ShortDescription? = null

   /* @Ignore
    constructor(
        id: String,
        name: String,
        pickers: Array<ProductModel>,
        short_description: ShortDescription
    ) : this() {
       this.id = id
        this.name = name
        this.pickers = pickers
        this.short_description = short_description
    }

    constructor(parcel: Parcel) : this() {
        id = parcel.readString().toString()
        name = parcel.readString()
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        arrayOf<ProductModel>().apply {
            parcel.readArrayList(ProductModel::class.java.classLoader)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailProductModel> {
        override fun createFromParcel(parcel: Parcel): DetailProductModel {
            return DetailProductModel(parcel)
        }

        override fun newArray(size: Int): Array<DetailProductModel?> {
            return arrayOfNulls(size)
        }
    }*/


}
