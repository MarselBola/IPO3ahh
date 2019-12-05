package com.example.crearpartida.triggers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.crearpartida.Globals;
import com.example.crearpartida.Jugador;
import com.example.crearpartida.Partida;
import com.example.crearpartida.R;

public class TriggersFragment extends Fragment {
    
    private Partida partida = Globals.getInstance().getGame();
    private Jugador jugador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_triggers, container, false);
        
        Button boto;
        TableRow row;
        TableLayout tl = root.findViewById(R.id.tlTrigger);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        
        for(int i = 0; i < partida.getLlistaJugadors().length; i++){
            jugador = partida.getLlistaJugadors()[i];
            
            row = new TableRow(getContext());
            row.setLayoutParams(lp);
    
            boto = new Button(getContext());
            boto.setText(jugador.getNom());
            boto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    partida.setJugadorAvisos(jugador);
                    Intent toTriggers = new Intent(getActivity(), Avisos.class);
                    startActivity(toTriggers);
                }
            });
            
            row.addView(boto);
            tl.addView(row);
        }
        
        return root;
    }
}