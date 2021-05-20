package com.johri.secondtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> labelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.firstFragmentContainer, FirstFragment.class, null)
                    .add(R.id.secondFragmentContainer, SecondFragment.class, null)
                    .commit();
        }
    }
}