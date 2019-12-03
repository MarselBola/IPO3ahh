package com.example.crearpartida.triggers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.crearpartida.Avisos;
import com.example.crearpartida.R;

public class TriggersFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_triggers, container, false);
        Intent toTriggers = new Intent(getActivity(), Avisos.class);
        startActivity(toTriggers);
        

        return root;
    }
}