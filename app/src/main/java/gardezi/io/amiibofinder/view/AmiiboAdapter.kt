package gardezi.io.amiibofinder.view


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gardezi.io.amiibofinder.databinding.AmiiboListItemBinding
import gardezi.io.amiibofinder.model.Amiibo
import java.util.*

class AmiiboAdapter() : RecyclerView.Adapter<AmiiboAdapter.AmiiboViewHolder>() {

    private var mAmiibos: List<Amiibo> = ArrayList()

    public fun updateData(amiibos: List<Amiibo>?) {
        if (amiibos != null && amiibos.isNotEmpty()) {
            mAmiibos = amiibos
            notifyDataSetChanged()
        }
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
