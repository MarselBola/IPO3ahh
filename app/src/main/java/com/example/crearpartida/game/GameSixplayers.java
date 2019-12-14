package com.example.crearpartida.game;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.crearpartida.clases.Globals;
import com.example.crearpartida.clases.Jugador;
import com.example.crearpartida.R;
import com.example.crearpartida.triggers.Avis;

import java.util.ArrayList;

public class GameSixplayers extends Fragment {

    private Globals g = Globals.getInstance();
    private Jugador player;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.game_sixplayers, container, false);
        player = g.getGame().getJugadorActual();
        g.getGame().setJugadorActual(g.getGame().getJugadors()[g.getGame().getTorn()]);
        if(g.getGame().getNumJug()==1){
            root.findViewById(R.id.game_extraplayers).setVisibility(View.GONE);
        }
        final TextView player1_name = root.findViewById(R.id.player1_name);
        player1_name.setText(g.getGame().getJugadors()[g.getGame().getTorn()].getNom());
        final Button bPasar =  root.findViewById(R.id.bPasar);
        bPasar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<Avis> avisos = player.getLlistaAvisos();
                String nom1 = player.getNom();
                StringBuilder mensage = new StringBuilder(nom1 + "\n");
                for(int i=0; i<avisos.size(); i++){
                    if(avisos.get(i).getQuan() == 2)
                        if(mensage.length() == 0)
                            mensage.append("-> ").append(avisos.get(i).getDescripcio());
                        else
                            mensage.append("\n-> ").append(avisos.get(i).getDescripcio());
                }

                g.getGame().nextTurn();
                g.getGame().setJugadorActual(g.getGame().getJugadors()[g.getGame().getTorn()]);
                player = g.getGame().getJugadorActual();
                Fragment sixplayersgame = new GameSixplayers();
                FragmentManager fm;
                if (getParentFragment() != null) {
                    fm = getParentFragment().getChildFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.oneplayer, sixplayersgame);
                    fragmentTransaction.commit();
                }


                avisos = player.getLlistaAvisos();
                mensage.append("\n\n").append(player.getNom()).append("\n");
                for(int i=0; i<avisos.size(); i++){
                    if(avisos.get(i).getQuan() == 1)
                        if(mensage.length() == 0)
                            mensage.append("-> ").append(avisos.get(i).getDescripcio());
                        else
                            mensage.append("\n-> ").append(avisos.get(i).getDescripcio());
                }

                if(!mensage.toString().equals(nom1 + "\n\n\n" + player.getNom() + "\n")){
                    Toast toast1 = new Toast(getContext());
                    View toast_layout = getLayoutInflater().inflate(R.layout.toast_avis, (ViewGroup) root.findViewById(R.id.tvToast));
                    toast1.setView(toast_layout);
                    TextView textView = (TextView) toast_layout.findViewById(R.id.toastMessage);
                    textView.setText(mensage);
                    toast1.setDuration(Toast.LENGTH_LONG);
                    toast1.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast1.show();
                }
            }
        });
        
        // aumentar y disminuir vida jugador 1
        final TextView player1_life = root.findViewById(R.id.player1_life);
        final ImageView player1_lifeup =  root.findViewById(R.id.player1_lifeup);

        player1_life.setText(String.valueOf(player.getVida()));
        player1_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player.setVida(player.getVida()+1);
                player1_life.setText(String.valueOf(player.getVida()));

            }
        });

        final ImageView player1_lifedown =  root.findViewById(R.id.player1_lifedown);
        player1_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player1_life.getText().toString()) > 0)
                {
                    player.setVida(player.getVida()-1);
                    player1_life.setText(String.valueOf(player.getVida()));

                }
            }
        });


        root.findViewById(R.id.game_extraplayers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment sixplayersgame = new GameSixplayersE();
                FragmentManager fm = getParentFragment().getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.oneplayer, sixplayersgame);
                fragmentTransaction.commit();
            }
        });

        return root;
    }


}