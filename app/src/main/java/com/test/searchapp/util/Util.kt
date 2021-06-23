package com.test.searchapp.util

import android.content.Context
import androidx.room.Room
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.searchapp.data.api.ApiSearch
import com.test.searchapp.data.db.SearchDataBase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val DATABASE_NAME = "search.db"
object Util {

    fun gsonProvider(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setLenient().create()
    }

    fun okHttpClientProvider(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    fun retrofitProvider(okHttpClient: OkHttpClient, gson: Gson): ApiSearch {
        return Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com/products/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiSearch::class.java)
    }

    fun dataBaseProvider(context: Context): SearchDataBase {
        return Room.databaseBuilder(context, SearchDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}