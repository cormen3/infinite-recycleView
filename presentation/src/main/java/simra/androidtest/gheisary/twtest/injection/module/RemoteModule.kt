package simra.androidtest.gheisary.twtest.injection.module

import dagger.Module
import dagger.Provides
import ir.cobal.data.network.core.RestDataSource
import simra.androidtest.gheisary.twtest.film.details.model.FilmDetailsDataStore
import simra.androidtest.gheisary.twtest.film.details.model.FilmDetailsRemote
import simra.androidtest.gheisary.twtest.film.list.model.FilmListDataStore
import simra.androidtest.gheisary.twtest.film.list.model.FilmListRemote

@Module
abstract class RemoteModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun provideFilmListRemote(restDataSource: RestDataSource): FilmListDataStore.Remote {
            return FilmListRemote(restDataSource)
        }

        @JvmStatic
        @Provides
        internal fun provideFilmDetailsRemote(restDataSource: RestDataSource): FilmDetailsDataStore.Remote {
            return FilmDetailsRemote(restDataSource)
        }

    }
}