package com.johri.secondtask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.johri.secondtask.R;

public class SecondFragment extends Fragment {

    EditText etLabel;
    Button btnAddLabel, btnDeleteLabel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        etLabel = view.findViewById(R.id.etLabel);
        btnAddLabel = view.findViewById(R.id.btnAdd);
        btnDeleteLabel = view.findViewById(R.id.btnDelete);

        btnAddLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String label = etLabel.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("label", label);
                if(!label.trim().equals("")){
                    getParentFragmentManager().setFragmentResult("addLabel", bundle);
                }
            }
        });

        btnDeleteLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().setFragmentResult("deleteLabel", null);
            }
        });

        return view;
    }
}
