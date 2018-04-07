package gardezi.io.amiibofinder.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import java.util.ArrayList

import gardezi.io.amiibofinder.databinding.AmiiboListItemBinding
import gardezi.io.amiibofinder.model.Amiibo
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel

class AmiiboAdapter(context: Context) : RecyclerView.Adapter<AmiiboAdapter.AmiiboViewHolder>() {

    private var mAmiibos: List<Amiibo> = ArrayList()
    private val mAmiiboViewModel = ViewModelProviders.of(context as FragmentActivity).get(AmiiboViewModel::class.java)

    init {
        mAmiiboViewModel.amiibos.observe(context as FragmentActivity, Observer { if (it != null) this.updateData(it) })
    }

    private fun updateData(amiibos: List<Amiibo>) {
        mAmiibos = amiibos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmiiboViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AmiiboListItemBinding.inflate(layoutInflater, parent, false)
        return AmiiboViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AmiiboViewHolder, position: Int) {
        val amiibo = mAmiibos[position]
        holder.bind(amiibo)
    }

    override fun getItemCount(): Int {
        return mAmiibos.size
    }

    class AmiiboViewHolder(private val binding: AmiiboListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(amiibo: Amiibo) {
            binding.amiibo = amiibo
            binding.executePendingBindings()
        }
    }
}
