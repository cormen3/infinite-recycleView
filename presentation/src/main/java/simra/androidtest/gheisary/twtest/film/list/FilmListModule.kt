package simra.androidtest.gheisary.twtest.film.list

import dagger.Binds
import dagger.Module

@Module
abstract class FilmListModule {
    @Binds
    abstract fun provideFilmListFragment(filmListFragment: FilmListFragment): FilmListFragment
}