package gardezi.io.amiibofinder.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gardezi.io.amiibofinder.view.AmiiboListFragment

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    internal abstract fun contributeAmiiboListFragment(): AmiiboListFragment

}
