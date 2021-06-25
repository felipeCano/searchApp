package com.test.searchapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.searchapp.domain.modellocal.DetailProductModel
import io.reactivex.Single

@Dao
interface DetailProductDao {
    @Query("SELECT * FROM DetailProductModel WHERE id = :detailId")
    fun detail(detailId: String): Single<DetailProductModel>

    @Query("SELECT * FROM DetailProductModel WHERE id ")
    fun details(): Single<List<DetailProductModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetails(search: List<DetailProductModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(detailProductModel: DetailProductModel)
}