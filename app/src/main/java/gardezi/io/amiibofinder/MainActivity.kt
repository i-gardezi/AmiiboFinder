package gardezi.io.amiibofinder

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import gardezi.io.amiibofinder.view.AmiiboListFragment
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel

/**
 * Created by imran on 07/04/2018.
 */

class MainActivity : AppCompatActivity() {

    private var mAmiiboViewModel: AmiiboViewModel? = null
    private var mAmiiboListFragment: AmiiboListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAmiiboViewModel = ViewModelProviders.of(this).get(AmiiboViewModel::class.java)
        mAmiiboViewModel!!.getAmiibosByName(AMIIBO_NAME_MARIO)
        showAmiiboListFragment()
    }

    private fun showAmiiboListFragment() {
        if (mAmiiboListFragment == null) {
            mAmiiboListFragment = AmiiboListFragment()
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, mAmiiboListFragment).commit()
    }

    companion object {
        private val AMIIBO_NAME_MARIO = "mario"
    }
}
