package simra.androidtest.gheisary.twtest.film.details.model

import io.reactivex.Single
import ir.cobal.data.network.core.RestDataSource
import ir.cobal.data.network.model.FilmDetailsResponse

class FilmDetailsRemote(private val restDataSource: RestDataSource): FilmDetailsDataStore.Remote {

    override fun getFilmDetails(id : String): Single<FilmDetailsResponse> {
        return  restDataSource.getFilmDetails(id)
    }
}