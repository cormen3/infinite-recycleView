package simra.androidtest.gheisary.twtest.film.list.model

import io.reactivex.Single
import ir.cobal.data.network.core.RestDataSource
import ir.cobal.data.network.model.SearchResult

class FilmListRemote(private val restDataSource: RestDataSource): FilmListDataStore.Remote {
    override fun searchFilms(searchKey: String, page:Int): Single<SearchResult> {
        return restDataSource.searchFilms(searchKey, page)
    }
}