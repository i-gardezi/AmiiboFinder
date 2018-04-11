package gardezi.io.amiibofinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import gardezi.io.amiibofinder.view.AmiiboListFragment;

/**
 * Created by imran on 07/04/2018.
 */

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final String AMIIBO_NAME_MARIO = "mario";

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private AmiiboListFragment mAmiiboListFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAmiiboListFragment();
    }

    private void showAmiiboListFragment() {
        if (mAmiiboListFragment == null) {
            mAmiiboListFragment = AmiiboListFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mAmiiboListFragment).commit();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
