package ir.cobal.data.network.core

import io.reactivex.Single
import ir.cobal.data.network.model.FilmDetailsResponse
import ir.cobal.data.network.model.SearchResult


interface ApiRepository {
    companion object {
            val BASE_URL: String get() = "http://www.omdbapi.com/"
            val API_KEY: String get() = "9af01761"
    }

    fun searchFilms(searchKey: String, page: Int): Single<SearchResult>
    fun getFilmDetails(id: String): Single<FilmDetailsResponse>
}