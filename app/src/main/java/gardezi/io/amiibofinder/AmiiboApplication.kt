package gardezi.io.amiibofinder

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import gardezi.io.amiibofinder.dagger.AppInjector
import javax.inject.Inject

class AmiiboApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    companion object {
        var instance: AmiiboApplication? = null
            private set
    }

}
