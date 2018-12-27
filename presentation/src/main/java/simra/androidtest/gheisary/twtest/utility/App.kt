package simra.androidtest.gheisary.twtest.utility

import android.app.Activity
import android.app.Application
import android.support.multidex.MultiDexApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import simra.androidtest.gheisary.twtest.injection.DaggerAppComponent
import javax.inject.Inject

class App: MultiDexApplication(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}