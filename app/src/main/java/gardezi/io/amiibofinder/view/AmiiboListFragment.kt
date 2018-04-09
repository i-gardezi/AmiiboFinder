package gardezi.io.amiibofinder.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import gardezi.io.amiibofinder.R
import kotlinx.android.synthetic.main.fragment_amiibo_list.*

class AmiiboListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_amiibo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListView()
    }

    private fun setUpListView() {
        amiibo_recycler_view.layoutManager = LinearLayoutManager(activity as FragmentActivity)
        amiibo_recycler_view.adapter = AmiiboAdapter(activity as FragmentActivity)
    }
}
