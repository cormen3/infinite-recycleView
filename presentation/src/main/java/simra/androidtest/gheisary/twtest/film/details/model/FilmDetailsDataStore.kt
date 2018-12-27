package simra.androidtest.gheisary.twtest.film.details.model

import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import ir.cobal.data.network.model.*

class FilmDetailsDataStore {
    interface Repository {
        val activeWorksDetailOutcome: PublishSubject<Outcome<FilmDetailsResponse>>
        fun getFilmDetails(projectId:String)
        fun handleError(error: Throwable)
    }

    interface Local {}

    interface Remote {
        fun getFilmDetails(projectId:String) : Single<FilmDetailsResponse>
    }
}