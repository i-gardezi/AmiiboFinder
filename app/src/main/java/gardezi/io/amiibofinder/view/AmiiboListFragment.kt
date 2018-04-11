package gardezi.io.amiibofinder.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import gardezi.io.amiibofinder.R
import gardezi.io.amiibofinder.dagger.Injectable
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel
import kotlinx.android.synthetic.main.fragment_amiibo_list.*
import javax.inject.Inject

class AmiiboListFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var mAdapter = AmiiboAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_amiibo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mAmiiboViewModel = ViewModelProviders.of(this, viewModelFactory).get(AmiiboViewModel::class.java)
        mAmiiboViewModel.getAmiibosByName("Mario")
        mAmiiboViewModel.amiibos.observe(this, Observer { it -> mAdapter.updateData(it) })
    }

    private fun setUpListView() {
        amiibo_recycler_view.layoutManager = LinearLayoutManager(activity as FragmentActivity)
        amiibo_recycler_view.adapter = mAdapter
    }
}
