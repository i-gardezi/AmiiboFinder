package gardezi.io.amiibofinder;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import gardezi.io.amiibofinder.view.AmiiboListFragment;
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel;

/**
 * Created by imran on 07/04/2018.
 */

public class MainActivity extends AppCompatActivity {

    private static final String AMIIBO_NAME_MARIO = "mario";

    private AmiiboViewModel mAmiiboViewModel;
    private AmiiboListFragment mAmiiboListFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAmiiboViewModel = ViewModelProviders.of(this).get(AmiiboViewModel.class);
        mAmiiboViewModel.getAmiibosByName(AMIIBO_NAME_MARIO);
        showAmiiboListFragment();
    }

    private void showAmiiboListFragment() {
        if (mAmiiboListFragment == null) {
            mAmiiboListFragment = new AmiiboListFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mAmiiboListFragment).commit();
    }
}
