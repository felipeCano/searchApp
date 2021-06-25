package com.test.searchapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.searchapp.domain.modellocal.DetailProductModel
import com.test.searchapp.domain.modellocal.SearchLocal

@Database(entities = [SearchLocal::class, DetailProductModel::class], version = 5, exportSchema = false)
abstract class SearchDataBase : RoomDatabase(){
    abstract fun seachDao() : SearchDao
    abstract fun detailDao() : DetailProductDao
}