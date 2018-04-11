package gardezi.io.amiibofinder.dagger

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import gardezi.io.amiibofinder.AmiiboApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, MainActivityModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AmiiboApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: AmiiboApplication)
}
