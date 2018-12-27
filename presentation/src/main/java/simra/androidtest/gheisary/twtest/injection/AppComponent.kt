package simra.androidtest.gheisary.twtest.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import simra.androidtest.gheisary.twtest.injection.module.AppModule
import simra.androidtest.gheisary.twtest.injection.module.ViewModelModule
import simra.androidtest.gheisary.twtest.utility.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ViewModelModule::class, AppModule::class, ActivityBuilder::class])
    interface AppComponent {
        @Component.Builder
        interface Builder {
            @BindsInstance
            fun application(application: Application): Builder

            fun build(): AppComponent
        }
        fun inject(app: App)
    }