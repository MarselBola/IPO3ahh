package com.example.crearpartida.pool;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.crearpartida.ManaAvaiable;
import com.example.crearpartida.R;

public class PoolFragment extends Fragment {


    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_pool, container, false);
        Intent toPool = new Intent(getActivity(), ManaAvaiable.class);
        startActivity(toPool);
        return root;
    }


}