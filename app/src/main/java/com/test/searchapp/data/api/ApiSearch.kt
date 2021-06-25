package com.test.searchapp.data.api

import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val ACCEPT_TOKEN: String = "Accept: application/json"
const val CONTENT_TYPE: String = "Content-Type: application/json"

const val STATUS: String = "active"
const val SITE_ID: String = "MLA"
const val Q: String = "Samsung%20Galaxy%20S8"
const val DOMAIN_ID: String = "MLA-CELLPHONES"


interface ApiSearch {

    @Headers(ACCEPT_TOKEN,CONTENT_TYPE)
    @GET("search")
    fun getSearch(
        @Query("status") status: String = STATUS,
        @Query("site_id") site_id: String = SITE_ID,
        @Query("q") q: String = Q,
        @Query("domain_id") domain_id: String = DOMAIN_ID,
    ): Observable<JsonElement>


    @Headers(ACCEPT_TOKEN, CONTENT_TYPE)
    @GET("{PRODUCT_ID}")
    fun getDetailProduct(
        @Path("PRODUCT_ID") producId: String,
    ): Observable<JsonElement>
}