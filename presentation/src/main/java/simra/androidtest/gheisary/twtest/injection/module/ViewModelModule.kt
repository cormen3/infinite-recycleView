package simra.androidtest.gheisary.twtest.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import simra.androidtest.gheisary.twtest.film.activity.FilmViewModel
import simra.androidtest.gheisary.twtest.film.details.FilmDetailsViewModel
import simra.androidtest.gheisary.twtest.film.list.FilmListViewModel
import simra.androidtest.gheisary.twtest.injection.ViewModelFactory
import simra.androidtest.gheisary.twtest.injection.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FilmViewModel::class)
    abstract fun bindFilmViewModel(filmViewModel: FilmViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FilmListViewModel::class)
    abstract fun bindFilmListViewModel(filmListViewModel: FilmListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FilmDetailsViewModel::class)
    abstract fun bindFilmDetailsViewModel(filmDetailsViewModel: FilmDetailsViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}