package ir.cobal.data.network.core

import io.reactivex.Single
import ir.cobal.data.network.core.ApiRepository.Companion.API_KEY
import ir.cobal.data.network.model.FilmDetailsResponse
import ir.cobal.data.network.model.SearchResult

class  RestDataSource constructor(var restapi: Restapi): ApiRepository {
    override fun getFilmDetails(id: String): Single<FilmDetailsResponse> {
        return restapi.getFilmDetails(API_KEY, id)
    }

    override fun searchFilms(searchKey: String, page:Int): Single<SearchResult> {
        return restapi.searchFilms(API_KEY, searchKey, page)
    }

}