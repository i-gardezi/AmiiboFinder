package gardezi.io.amiibofinder.dagger.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import gardezi.io.amiibofinder.AmiiboApplication
import gardezi.io.amiibofinder.dagger.AppModule
import gardezi.io.amiibofinder.dagger.MainActivityModule
import gardezi.io.amiibofinder.dagger.modules.DataModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (MainActivityModule::class), (DataModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AmiiboApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: AmiiboApplication)
}
