package com.example.crearpartida.triggers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.crearpartida.clases.Globals;
import com.example.crearpartida.clases.Jugador;
import com.example.crearpartida.clases.Partida;
import com.example.crearpartida.R;
import com.example.crearpartida.game.GameFragment;
import com.example.crearpartida.game.GameSixplayers;

public class TriggersFragment extends Fragment {
    View root;
    private Partida partida = Globals.getInstance().getGame();
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_triggers, container, false);
        
        Button boto;
        TableRow row;
        TableLayout tl = root.findViewById(R.id.tlTrigger);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        Jugador jugador;
        final Intent toTriggers = new Intent(getActivity(), Avisos.class);

        if(partida.getNumJug() == 1){
            partida.setJugadorAvisos(partida.getLlistaJugadors()[0]);
            toTriggers.putExtra("player", partida.getLlistaJugadors()[0].getNom());
            startActivityForResult(toTriggers, 1);
        }
        else
            for(int i = 0; i < partida.getLlistaJugadors().length; i++){
                jugador = partida.getLlistaJugadors()[i];

                row = new TableRow(getContext());
                row.setLayoutParams(lp);

                boto = new Button(getContext());
                boto.setText(jugador.getNom());
                boto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = partida.buscarPosJugador(((Button) v).getText().toString());
                        partida.setJugadorAvisos(partida.getLlistaJugadors()[pos]);
                        toTriggers.putExtra("player", ((Button) v).getText().toString());
                        startActivity(toTriggers);
                    }
                });

                row.addView(boto);
                tl.addView(row);
            }

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){

            if(requestCode == 1){
                Navigation.findNavController(root).navigate(R.id.nav_game);
            }
        }
    }
}