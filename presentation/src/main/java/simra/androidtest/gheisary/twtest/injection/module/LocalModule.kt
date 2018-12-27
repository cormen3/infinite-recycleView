package simra.androidtest.gheisary.twtest.injection.module

import dagger.Module
import dagger.Provides
import ir.cobal.data.local.preference.PreferenceService
import simra.androidtest.gheisary.twtest.film.details.model.FilmDetailsDataStore
import simra.androidtest.gheisary.twtest.film.details.model.FilmDetailsLocalData
import simra.androidtest.gheisary.twtest.film.list.model.FilmListDataStore
import simra.androidtest.gheisary.twtest.film.list.model.FilmListLocalData

@Module
abstract class LocalModule {

    @Module
    companion object {


        @JvmStatic
        @Provides
        internal fun provideFilmListLocalData(preferenceService: PreferenceService): FilmListDataStore.Local {
            return FilmListLocalData(preferenceService)
        }

        @JvmStatic
        @Provides
        internal fun provideFilmDetailsLocalData(preferenceService: PreferenceService): FilmDetailsDataStore.Local {
            return FilmDetailsLocalData(preferenceService)
        }

    }
}