package com.android.searchphotos.api

import com.android.searchphotos.BuildConfig
import com.android.searchphotos.data.UnsplashResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    companion object {
        const val BASE_URL = "https://api.unspash.com/"
        const val ACCESS_KEY = BuildConfig.UNSPLASH_ACCESS_KEY
    }

    @Headers("Accept-Version: v1", "Authorization: client-ID $ACCESS_KEY")
    @GET("search/photos")

    //suspending function is threading kotlin coroutines
    //https://kotlinlang.org/docs/composing-suspending-functions.html#lazily-started-async
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}