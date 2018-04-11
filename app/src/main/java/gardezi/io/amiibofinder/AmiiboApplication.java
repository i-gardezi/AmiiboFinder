package gardezi.io.amiibofinder;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import gardezi.io.amiibofinder.dagger.injector.AppInjector;

public class AmiiboApplication extends Application implements HasActivityInjector {

    private static AmiiboApplication instance;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    public static AmiiboApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppInjector.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

}
