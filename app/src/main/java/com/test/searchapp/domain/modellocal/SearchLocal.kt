package com.test.searchapp.domain.modellocal

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "SearchLocal" , indices = [Index(value = ["id"], unique = true)])
data class SearchLocal(
    @PrimaryKey
    val id: String,
    @SerializedName("name")
    val originalName: String,
)