package gardezi.io.amiibofinder.dagger.modules;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gardezi.io.amiibofinder.dagger.components.ViewModelSubComponent;
import gardezi.io.amiibofinder.data.network.AmiiboApi;
import gardezi.io.amiibofinder.data.AmiiboRepository;
import gardezi.io.amiibofinder.data.network.AmiiboWebService;
import gardezi.io.amiibofinder.model.Amiibo;
import gardezi.io.amiibofinder.viewmodel.CustomViewModelFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// Because we wish to setup caching, we need an Application context.
// Our first Dagger module, AppModule.java, will be used to provide this reference.
// We will define a method annotated with @Provides that informs Dagger that this
// method is the constructor for the Application return type
// (i.e., it is the method in charge of providing the instance of the Application class):

@Module(subcomponents = {ViewModelSubComponent.class})
public class AppModule {

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return new CustomViewModelFactory(viewModelSubComponent.build());
    }

}
