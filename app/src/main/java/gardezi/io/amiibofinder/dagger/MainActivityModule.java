package gardezi.io.amiibofinder.dagger;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import gardezi.io.amiibofinder.MainActivity;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}