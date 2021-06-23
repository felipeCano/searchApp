package com.test.searchapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.searchapp.domain.modellocal.SearchLocal

@Database(entities = [SearchLocal::class], version = 1, exportSchema = false)
abstract class SearchDataBase : RoomDatabase(){
    abstract fun seachDao() : SearchDao
}