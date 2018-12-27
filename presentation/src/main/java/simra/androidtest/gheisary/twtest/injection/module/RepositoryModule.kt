package simra.androidtest.gheisary.twtest.injection.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ir.cobal.data.network.core.Scheduler
import simra.androidtest.gheisary.twtest.film.details.model.FilmDetailsDataStore
import simra.androidtest.gheisary.twtest.film.details.model.FilmDetailsRepository
import simra.androidtest.gheisary.twtest.film.list.model.FilmListDataStore
import simra.androidtest.gheisary.twtest.film.list.model.FilmListRepository

@Module
abstract class RepositoryModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun provideFilmListRepository(local: FilmListDataStore.Local,
                                            remote: FilmListDataStore.Remote,
                                            scheduler: Scheduler,
                                            compositeDisposable: CompositeDisposable): FilmListDataStore.Repository {
            return FilmListRepository(local, remote, scheduler, compositeDisposable)
        }


        @JvmStatic
        @Provides
        internal fun provideFilmDetailsRepository(local: FilmDetailsDataStore.Local,
                                            remote: FilmDetailsDataStore.Remote,
                                            scheduler: Scheduler,
                                            compositeDisposable: CompositeDisposable): FilmDetailsDataStore.Repository {
            return FilmDetailsRepository(local, remote, scheduler, compositeDisposable)
        }


    }
}