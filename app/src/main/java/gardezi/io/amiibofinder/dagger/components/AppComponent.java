package gardezi.io.amiibofinder.dagger.components;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import gardezi.io.amiibofinder.AmiiboApplication;
import gardezi.io.amiibofinder.dagger.modules.AppModule;
import gardezi.io.amiibofinder.dagger.modules.MainActivityModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, MainActivityModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(AmiiboApplication application);
        AppComponent build();
    }

    void inject(AmiiboApplication application);
}
