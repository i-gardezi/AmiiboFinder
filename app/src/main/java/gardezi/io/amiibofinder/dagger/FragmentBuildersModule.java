package gardezi.io.amiibofinder.dagger;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import gardezi.io.amiibofinder.view.AmiiboListFragment;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract AmiiboListFragment contributeAmiiboListFragment();

}
