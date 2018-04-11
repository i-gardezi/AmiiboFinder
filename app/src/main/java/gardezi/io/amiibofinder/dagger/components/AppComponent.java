package gardezi.io.amiibofinder.dagger.components;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import gardezi.io.amiibofinder.AmiiboApplication;
import gardezi.io.amiibofinder.dagger.modules.AppModule;
import gardezi.io.amiibofinder.dagger.modules.MainActivityModule;
import gardezi.io.amiibofinder.dagger.modules.NetworkModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, MainActivityModule.class, NetworkModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(AmiiboApplication application);
        AppComponent build();
    }

    void inject(AmiiboApplication application);
}
