package gardezi.io.amiibofinder.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gardezi.io.amiibofinder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmiiboListFragment extends Fragment {

    public static AmiiboListFragment newInstance() {
        return new AmiiboListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amiibo_list, container, false);
        setUpListView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setUpListView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.amiibo_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new AmiiboAdapter(getActivity()));
    }
}
