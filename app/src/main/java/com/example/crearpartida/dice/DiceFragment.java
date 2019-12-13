package com.example.crearpartida.dice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.crearpartida.R;
import com.example.crearpartida.game.GameSixplayers;

public class DiceFragment extends Fragment {

    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_dice, container, false);
        Intent toDice = new Intent(getActivity(), DausActivity.class);
        startActivityForResult(toDice, 2);
        return root;
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    
        if(resultCode == Activity.RESULT_OK){

            if(requestCode == 2){
                Navigation.findNavController(root).navigate(R.id.nav_game);
            }
        }
    }
}