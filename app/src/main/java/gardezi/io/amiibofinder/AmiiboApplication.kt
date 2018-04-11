package gardezi.io.amiibofinder

import android.app.Activity
import android.app.Application

import javax.inject.Inject

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import gardezi.io.amiibofinder.dagger.AppInjector

class AmiiboApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

}
