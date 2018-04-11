package gardezi.io.amiibofinder.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gardezi.io.amiibofinder.databinding.AmiiboListItemBinding;
import gardezi.io.amiibofinder.model.Amiibo;

public class AmiiboAdapter extends RecyclerView.Adapter {

    private List<Amiibo> mAmiibos = new ArrayList<>();

    public AmiiboAdapter() {
    }

    public void updateData(List<Amiibo> amiibos) {
        mAmiibos = amiibos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AmiiboListItemBinding binding = AmiiboListItemBinding.inflate(layoutInflater, parent, false);
        return new AmiiboViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Amiibo amiibo = mAmiibos.get(position);
        ((AmiiboViewHolder) holder).bind(amiibo);
    }

    @Override
    public int getItemCount() {
        return mAmiibos.size();
    }

    class AmiiboViewHolder extends RecyclerView.ViewHolder {

        private final AmiiboListItemBinding binding;

        AmiiboViewHolder(AmiiboListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Amiibo amiibo) {
            binding.setAmiibo(amiibo);
            binding.executePendingBindings();
        }
    }
}
