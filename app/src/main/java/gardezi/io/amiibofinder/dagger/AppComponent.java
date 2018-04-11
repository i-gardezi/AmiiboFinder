package gardezi.io.amiibofinder.dagger;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import gardezi.io.amiibofinder.AmiiboApplication;

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
