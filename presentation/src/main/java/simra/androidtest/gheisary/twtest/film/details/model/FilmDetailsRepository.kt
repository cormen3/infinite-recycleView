package simra.androidtest.gheisary.twtest.film.details.model

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import ir.cobal.data.network.core.Scheduler
import ir.cobal.data.network.exception.ExceptionHandler
import ir.cobal.data.network.model.FilmDetailsResponse
import ir.cobal.data.network.model.Outcome
import simra.androidtest.gheisary.twtest.utility.extensions.*

class FilmDetailsRepository (
    private val local: FilmDetailsDataStore.Local,
    private val remote: FilmDetailsDataStore.Remote,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
): FilmDetailsDataStore.Repository {

    override val activeWorksDetailOutcome: PublishSubject<Outcome<FilmDetailsResponse>> = PublishSubject.create<Outcome<FilmDetailsResponse>>()


    override fun getFilmDetails(projectId:String) {
        remote.getFilmDetails(projectId)
                .performOnBackOutOnMain(scheduler)
                .doOnSubscribe{activeWorksDetailOutcome.loading(true)}
                .subscribe(
                        {loginInfo -> activeWorksDetailOutcome.loading(false); activeWorksDetailOutcome.success(loginInfo)},
                        {error -> activeWorksDetailOutcome.loading(false); handleError(error)}
                )
                .addTo(compositeDisposable)
    }


    override fun handleError(error: Throwable) {
        val exception = ExceptionHandler.handleError(error)
        activeWorksDetailOutcome.failed(exception)
    }

}