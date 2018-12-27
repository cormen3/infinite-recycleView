package simra.androidtest.gheisary.twtest.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import simra.androidtest.gheisary.twtest.film.activity.FilmActivity
import simra.androidtest.gheisary.twtest.film.activity.FilmFragmentProvider
import simra.androidtest.gheisary.twtest.film.activity.FilmModule

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FilmModule::class, FilmFragmentProvider::class])
    abstract fun bindFilmActivity(): FilmActivity

}