package gardezi.io.amiibofinder

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import gardezi.io.amiibofinder.view.AmiiboListFragment
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel

/**
 * Created by imran on 07/04/2018.
 */

class MainActivity : AppCompatActivity() {

    private var mAmiiboViewModel = ViewModelProviders.of(this).get(AmiiboViewModel::class.java)
    private var mAmiiboListFragment = AmiiboListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAmiiboList()
    }

    private fun showAmiiboList() {
        mAmiiboViewModel.getAmiibosByName(AMIIBO_NAME_MARIO)
        supportFragmentManager.beginTransaction().replace(R.id.container, mAmiiboListFragment).commit()
    }

    companion object {
        private val AMIIBO_NAME_MARIO = "mario"
    }
}
