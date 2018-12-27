package ir.cobal.data.network.core

import io.reactivex.Single
import ir.cobal.data.network.model.FilmDetailsResponse
import ir.cobal.data.network.model.SearchResult
import retrofit2.http.*


interface  Restapi {

    @Headers("Content-Type: application/json")
    @GET(".")
    fun searchFilms(@Query("apiKey") apiKey: String, @Query("s") searchKey: String, @Query("page") page: Int): Single<SearchResult>


    @Headers("Content-Type: application/json")
    @GET(".")
    fun getFilmDetails(@Query("apiKey") apiKey: String, @Query("i") id: String): Single<FilmDetailsResponse>

}