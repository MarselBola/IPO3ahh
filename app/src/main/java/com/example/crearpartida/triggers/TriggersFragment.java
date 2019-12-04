package com.example.crearpartida.triggers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.crearpartida.*;

public class TriggersFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_triggers, container, false);
        
    
        Jugador[] llistaJug = Globals.getInstance().getGame().getLlistaJugadors();
        Jugador jugador;
        for(int i=0; i<llistaJug.length; i++){
            jugador = llistaJug[i];
            
            // posar jugadors al layout
        }
    
        Intent toTriggers = new Intent(getActivity(), Avisos.class);
        startActivity(toTriggers);

        return root;
    }
}