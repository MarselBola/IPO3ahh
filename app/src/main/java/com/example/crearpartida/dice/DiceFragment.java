package com.example.crearpartida.dice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.crearpartida.DausActivity;
import com.example.crearpartida.R;
public class DiceFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dice, container, false);
        Intent toDice = new Intent(getActivity(), DausActivity.class);
        startActivity(toDice);
        return root;
    }
}