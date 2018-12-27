package simra.androidtest.gheisary.twtest.film.details

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.cobal.data.network.model.FilmDetailsResponse
import ir.cobal.data.network.model.Outcome
import simra.androidtest.gheisary.twtest.film.details.model.FilmDetailsDataStore
import simra.androidtest.gheisary.twtest.utility.extensions.toLiveData
import javax.inject.Inject

class FilmDetailsViewModel @Inject constructor(var repository: FilmDetailsDataStore.Repository, private val compositeDisposable: CompositeDisposable): ViewModel() {

    val activeWorksDetailOutcome: LiveData<Outcome<FilmDetailsResponse>> by lazy {
        repository.activeWorksDetailOutcome.toLiveData(compositeDisposable)
    }

    fun getFilmDetails(projectId:String) {
        repository.getFilmDetails(projectId)
    }
}