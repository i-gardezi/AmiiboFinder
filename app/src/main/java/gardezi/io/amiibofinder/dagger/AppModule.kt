package gardezi.io.amiibofinder.dagger

import android.arch.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import gardezi.io.amiibofinder.viewmodel.CustomViewModelFactory
import javax.inject.Singleton

// Because we wish to setup caching, we need an Application context.
// Our first Dagger module, AppModule.java, will be used to provide this reference.
// We will define a method annotated with @Provides that informs Dagger that this
// method is the constructor for the Application return type
// (i.e., it is the method in charge of providing the instance of the Application class):

@Module(subcomponents = arrayOf(ViewModelSubComponent::class))
class AppModule {

    @Singleton
    @Provides
    internal fun provideViewModelFactory(viewModelSubComponent: ViewModelSubComponent.Builder): ViewModelProvider.Factory {
        return CustomViewModelFactory(viewModelSubComponent.build())
    }

}
