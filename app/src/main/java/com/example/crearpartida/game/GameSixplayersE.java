package com.example.crearpartida.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.crearpartida.Globals;
import com.example.crearpartida.Jugador;
import com.example.crearpartida.R;

public class GameSixplayersE extends Fragment {
    Globals g = Globals.getInstance();
    Jugador player = g.getGame().getJugadors()[g.getGame().getTorn()];
    Jugador player2= g.getGame().getJugadors()[(g.getGame().getTorn() + 1) % g.getGame().getNumJug()];
    Jugador player3= g.getGame().getJugadors()[(g.getGame().getTorn() + 2) % g.getGame().getNumJug()];
    Jugador player4= g.getGame().getJugadors()[(g.getGame().getTorn() + 3) % g.getGame().getNumJug()];
    Jugador player5= g.getGame().getJugadors()[(g.getGame().getTorn() + 4) % g.getGame().getNumJug()];
    Jugador player6= g.getGame().getJugadors()[(g.getGame().getTorn() + 5) % g.getGame().getNumJug()];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.game_sixplayers_e, container, false);
        int resID;
        for(int i = g.getGame().getNumJug(); i<6;i++)
        {
            resID = getResources().getIdentifier("player" + (i+1), "id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.GONE);
        }


        // aumentar y disminuir vida jugador 1
        final TextView player1_life_e = root.findViewById(R.id.player1_life_e);
        final ImageButton player1_lifeup_e =  root.findViewById(R.id.player1_lifeup_e);
        player1_life_e.setText(String.valueOf(player6.getVida()));
        player1_lifeup_e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player.setVida(player.getVida()+1);
                player1_life_e.setText(String.valueOf(player.getVida()));

            }
        });

        final ImageButton player1_lifedown_e =  root.findViewById(R.id.player1_lifedown_e);
        player1_lifedown_e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player1_life_e.getText().toString()) > 0)
                {
                    player.setVida(player.getVida()-1);
                    player1_life_e.setText(String.valueOf(player.getVida()));
                }
            }
        });

        // aumentar y disminuir vida jugador 2
        final TextView player2_life = root.findViewById(R.id.player2_life);
        final ImageButton player2_lifeup =  root.findViewById(R.id.player2_lifeup);
        player2_life.setText(String.valueOf(player2.getVida()));
        player2_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player2.setVida(player2.getVida()+1);
                player2_life.setText(String.valueOf(player2.getVida()));

            }
        });

        final ImageButton player2_lifedown =  root.findViewById(R.id.player2_lifedown);
        player2_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player2_life.getText().toString()) > 0)
                {
                    player2.setVida(player2.getVida()-1);
                    player2_life.setText(String.valueOf(player2.getVida()));
                }
            }
        });

        // aumentar y disminuir vida jugador 3
        final TextView player3_life = root.findViewById(R.id.player3_life);
        final ImageButton player3_lifeup =  root.findViewById(R.id.player3_lifeup);
        player3_life.setText(String.valueOf(player3.getVida()));
        player3_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player3.setVida(player3.getVida()+1);
                player3_life.setText(String.valueOf(player3.getVida()));

            }
        });

        final ImageButton player3_lifedown =  root.findViewById(R.id.player3_lifedown);
        player3_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player3_life.getText().toString()) > 0)
                {
                    player3.setVida(player3.getVida()-1);
                    player3_life.setText(String.valueOf(player3.getVida()));
                }
            }
        });

        // aumentar y disminuir vida jugador 4
        final TextView player4_life = root.findViewById(R.id.player4_life);
        final ImageButton player4_lifeup =  root.findViewById(R.id.player4_lifeup);
        player4_life.setText(String.valueOf(player4.getVida()));
        player4_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player4.setVida(player4.getVida()+1);
                player4_life.setText(String.valueOf(player4.getVida()));

            }
        });

        final ImageButton player4_lifedown =  root.findViewById(R.id.player4_lifedown);
        player4_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player4_life.getText().toString()) > 0)
                {
                    player4.setVida(player4.getVida()-1);
                    player4_life.setText(String.valueOf(player4.getVida()));
                }
            }
        });

        // aumentar y disminuir vida jugador 5
        final TextView player5_life = root.findViewById(R.id.player5_life);
        final ImageButton player5_lifeup =  root.findViewById(R.id.player5_lifeup);
        player5_life.setText(String.valueOf(player5.getVida()));
        player5_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player5.setVida(player5.getVida()+1);
                player5_life.setText(String.valueOf(player5.getVida()));

            }
        });

        final ImageButton player5_lifedown =  root.findViewById(R.id.player5_lifedown);
        player5_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player5_life.getText().toString()) > 0)
                {
                    player5.setVida(player5.getVida()-1);
                    player5_life.setText(String.valueOf(player5.getVida()));
                }
            }
        });

        // aumentar y disminuir vida jugador 6
        final TextView player6_life = root.findViewById(R.id.player6_life);
        final ImageButton player6_lifeup =  root.findViewById(R.id.player6_lifeup);
        player6_life.setText(String.valueOf(player6.getVida()));
        player6_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player6.setVida(player5.getVida()+1);
                player6_life.setText(String.valueOf(player6.getVida()));

            }
        });

        final ImageButton player6_lifedown =  root.findViewById(R.id.player6_lifedown);
        player6_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player6_life.getText().toString()) > 0)
                {
                    player6.setVida(player6.getVida()-1);
                    player6_life.setText(String.valueOf(player6.getVida()));
                }
            }
        });

        root.findViewById(R.id.game_extraplayers_e).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment sixplayersgame = new GameSixplayers();
                FragmentManager fm = getParentFragment().getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.oneplayer, sixplayersgame);
                fragmentTransaction.commit();
            }
        });

        return root;
    }


}