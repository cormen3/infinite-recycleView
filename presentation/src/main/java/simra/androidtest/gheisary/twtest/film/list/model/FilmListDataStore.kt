package simra.androidtest.gheisary.twtest.film.list.model

import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import ir.cobal.data.network.model.SearchResult
import ir.cobal.data.network.model.Outcome

class FilmListDataStore {
    interface Repository {
        val filmOutcome: PublishSubject<Outcome<SearchResult>>
        fun searchFilms(searchKey: String, page:Int)
        fun saveFilmsInfo(searchResult: SearchResult)
        fun handleError(error: Throwable)
    }

    interface Local {
        fun saveFilmsInfo(searchResult: SearchResult)
    }

    interface Remote {
        fun searchFilms(searchKey: String, page:Int): Single<SearchResult>
    }
}