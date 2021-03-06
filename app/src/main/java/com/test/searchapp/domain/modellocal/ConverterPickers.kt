package com.test.searchapp.domain.modellocal

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterPickers {
    @TypeConverter
    fun storedStringToMyObjects(data: String?): Array<ProductModel> {
        val gson = Gson()
        if (data == null) {
            return emptyArray()
        }
        val listType = object : TypeToken<Array<ProductModel>>() {

        }.type
        return gson.fromJson<Array<ProductModel>>(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Array<ProductModel>): String {
        val gson = Gson()
        return gson.toJson(myObjects)
    }
}
