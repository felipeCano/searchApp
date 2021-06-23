package com.test.searchapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.searchapp.domain.modellocal.SearchLocal
import io.reactivex.Single

@Dao
interface SearchDao {
    @Query("SELECT * FROM SearchLocal WHERE id = :searchId")
    fun search(searchId: String): Single<SearchLocal>

    @Query("SELECT * FROM SearchLocal WHERE id ")
    fun searchs(): Single<List<SearchLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearchs(search: List<SearchLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearch(searchs: SearchLocal)
}