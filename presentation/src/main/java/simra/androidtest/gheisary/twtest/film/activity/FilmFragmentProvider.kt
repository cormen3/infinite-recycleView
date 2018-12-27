package simra.androidtest.gheisary.twtest.film.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import simra.androidtest.gheisary.twtest.film.details.FilmDetailsFragment
import simra.androidtest.gheisary.twtest.film.list.FilmListFragment
import simra.androidtest.gheisary.twtest.film.list.FilmListModule

@Module
abstract class FilmFragmentProvider {
    @ContributesAndroidInjector(modules = [FilmListModule::class])
    abstract fun provideFilmListFragment(): FilmListFragment


    @ContributesAndroidInjector(modules = [FilmListModule::class])
    abstract fun provideFilmDetailsFragment(): FilmDetailsFragment

}