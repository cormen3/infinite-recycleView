package simra.androidtest.gheisary.twtest.injection.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ir.cobal.data.local.preference.PreferenceService

@Module(includes = [ViewModelModule::class, NetworkModule::class, RemoteModule::class, LocalModule::class, RepositoryModule::class])
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun providePreferenceService(application: Application): PreferenceService {
            return PreferenceService(application)
        }

        @JvmStatic
        @Provides
        internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
    }
}