package gardezi.io.amiibofinder

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import gardezi.io.amiibofinder.view.AmiiboListFragment
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel
import javax.inject.Inject

/**
 * Created by imran on 07/04/2018.
 */

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    private var mAmiiboListFragment = AmiiboListFragment()
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAmiiboList()
    }

    private fun showAmiiboList() {
        supportFragmentManager.beginTransaction().replace(R.id.container, mAmiiboListFragment).commit()
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}
