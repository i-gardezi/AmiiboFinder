package gardezi.io.amiibofinder.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gardezi.io.amiibofinder.MainActivity

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    internal abstract fun contributeMainActivity(): MainActivity
}