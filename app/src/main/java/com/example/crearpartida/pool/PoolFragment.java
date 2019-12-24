package com.example.crearpartida.pool;

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
import com.example.crearpartida.*;
import com.example.crearpartida.clases.Globals;
import com.example.crearpartida.clases.Jugador;
import com.example.crearpartida.clases.Partida;

public class PoolFragment extends Fragment {
    private Partida partida = Globals.getInstance().getGame();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pool, container, false);
        Button boto;
        TableRow row;
        final TableLayout tl = root.findViewById(R.id.tlMana);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        Jugador jugador;

        final FragmentManager fm= getChildFragmentManager();
        final FragmentTransaction ft= fm.beginTransaction();
        if(partida.getNumJug() == 1){
            Globals.getInstance().setPlayer(partida.getLlistaJugadors()[0]);
            Fragment fragment= new ManaAvailable();
            ft.add(R.id.manafragment, fragment);
            ft.commit();
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
                        Globals.getInstance().setPlayer(partida.getLlistaJugadors()[pos]);
                        tl.setVisibility(View.GONE);
                        Fragment fragment= new ManaAvailable();
                        ft.add(R.id.manafragment, fragment);
                        ft.commit();
                    }
                });

                row.addView(boto);
                tl.addView(row);
            }


        return root;
    }
    private void doTransition(){

    }
}