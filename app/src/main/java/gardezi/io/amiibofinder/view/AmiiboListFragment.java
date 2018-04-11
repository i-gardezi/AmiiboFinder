package gardezi.io.amiibofinder.view;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import gardezi.io.amiibofinder.R;
import gardezi.io.amiibofinder.dagger.Injectable;
import gardezi.io.amiibofinder.data.AmiiboApi;
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmiiboListFragment extends Fragment implements Injectable {

    public static AmiiboListFragment newInstance() {
        return new AmiiboListFragment();
    }

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private AmiiboAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amiibo_list, container, false);
        setUpListView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final AmiiboViewModel mAmiiboViewModel = ViewModelProviders.of(this, viewModelFactory).get(AmiiboViewModel.class);
        mAmiiboViewModel.getAmiibosByName("Mario");
        mAmiiboViewModel.getAmiibos().observe(this, mAdapter::updateData);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setUpListView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.amiibo_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new AmiiboAdapter();
        recyclerView.setAdapter(mAdapter);
    }
}
