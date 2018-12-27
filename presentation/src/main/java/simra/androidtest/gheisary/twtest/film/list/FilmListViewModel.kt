package simra.androidtest.gheisary.twtest.film.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.cobal.data.network.model.SearchResult
import javax.inject.Inject
import simra.androidtest.gheisary.twtest.film.list.model.FilmListDataStore
import ir.cobal.data.network.model.Outcome
import simra.androidtest.gheisary.twtest.utility.extensions.toLiveData

class FilmListViewModel @Inject constructor(var repository: FilmListDataStore.Repository, private val compositeDisposable: CompositeDisposable):ViewModel() {

    val loginOutcome: LiveData<Outcome<SearchResult>> by lazy {
        repository.filmOutcome.toLiveData(compositeDisposable)
    }

    fun searchFilms(searchKey: String, page:Int){
        repository.searchFilms(searchKey, page)
    }
}