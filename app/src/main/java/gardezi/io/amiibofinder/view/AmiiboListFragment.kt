package gardezi.io.amiibofinder.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import gardezi.io.amiibofinder.R

class AmiiboListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_amiibo_list, container, false)
        setUpListView(view)
        return view
    }

    private fun setUpListView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.amiibo_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity as FragmentActivity)
        recyclerView.adapter = AmiiboAdapter(activity as FragmentActivity)
    }
}
