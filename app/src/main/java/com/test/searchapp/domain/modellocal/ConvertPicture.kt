package com.test.searchapp.domain.modellocal

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConvertPicture {
    @TypeConverter
    fun storedStringToMyObjects(data: String?): Array<PictureProduct> {
        val gson = Gson()
        if (data == null) {
            return emptyArray()
        }
        val listType = object : TypeToken<Array<PictureProduct>>() {

        }.type
        return gson.fromJson<Array<PictureProduct>>(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Array<PictureProduct>): String {
        val gson = Gson()
        return gson.toJson(myObjects)
    }
}