package com.johri.secondtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    RecyclerView rv;
    ArrayList<String> labelsList;
    ListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("addLabel", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String label = result.getString("label");
                labelsList.add(label);
                adapter.notifyItemInserted(labelsList.size());
                rv.smoothScrollToPosition(labelsList.size()-1);
            }
        });

        getParentFragmentManager().setFragmentResultListener("deleteLabel", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                adapter.deleteLabels();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        rv = view.findViewById(R.id.rv);
        labelsList = new ArrayList<>();
        adapter = new ListAdapter(container.getContext(), labelsList);
        rv.setLayoutManager(new LinearLayoutManager(container.getContext()));
        rv.setAdapter(adapter);

        return view;
    }
}
