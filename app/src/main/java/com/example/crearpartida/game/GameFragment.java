package com.example.crearpartida.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.crearpartida.R;
public class GameFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);

       FragmentManager fm= getChildFragmentManager();
       FragmentTransaction ft= fm.beginTransaction();

       Fragment fragment= new GameSixplayers();
       ft.add(R.id.oneplayer, fragment);
       ft.commit();




        return root;
    }

}