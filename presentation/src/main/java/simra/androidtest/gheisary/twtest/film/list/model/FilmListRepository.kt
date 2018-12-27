package simra.androidtest.gheisary.twtest.film.list.model

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import ir.cobal.data.network.model.SearchResult
import ir.cobal.data.network.exception.NetworkException
import ir.cobal.data.network.model.Outcome
import ir.cobal.data.network.core.Scheduler
import ir.cobal.data.network.exception.ExceptionHandler
import simra.androidtest.gheisary.twtest.utility.extensions.*

class FilmListRepository (
    private val local: FilmListDataStore.Local,
    private val remote: FilmListDataStore.Remote,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
): FilmListDataStore.Repository {

    override val filmOutcome: PublishSubject<Outcome<SearchResult>> = PublishSubject.create<Outcome<SearchResult>>()

    override fun searchFilms(searchKey: String, page:Int) {
        remote.searchFilms(searchKey, page)
                .performOnBackOutOnMain(scheduler)
                .doOnSubscribe{filmOutcome.loading(true)}
                .subscribe(
                        {    info -> if(info.Search!=null){filmOutcome.success(info)}
                            filmOutcome.loading(false)},
                        {error -> handleError(error)
                            filmOutcome.loading(false)}
                )
                .addTo(compositeDisposable)
    }

    override fun saveFilmsInfo(searchResult: SearchResult) {
        local.saveFilmsInfo(searchResult)
    }

    override fun handleError(error: Throwable) {
        val exception = ExceptionHandler.handleError(error)
        filmOutcome.failed(exception)
    }
}