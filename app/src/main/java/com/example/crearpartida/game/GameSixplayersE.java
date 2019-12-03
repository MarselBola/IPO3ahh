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

import com.example.crearpartida.R;

public class GameSixplayersE extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.game_sixplayers_e, container, false);

        // aumentar y disminuir vida jugador 1
        final TextView player1_life_e = root.findViewById(R.id.player1_life_e);
        final ImageButton player1_lifeup_e =  root.findViewById(R.id.player1_lifeup_e);
        player1_lifeup_e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player1_life_e.setText(String.valueOf(Integer.valueOf(player1_life_e.getText().toString())+1));

            }
        });

        final ImageButton player1_lifedown_e =  root.findViewById(R.id.player1_lifedown_e);
        player1_lifedown_e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player1_life_e.getText().toString()) > 0)
                {
                    player1_life_e.setText(String.valueOf(Integer.valueOf(player1_life_e.getText().toString())-1));
                }
            }
        });

        // aumentar y disminuir vida jugador 2
        final TextView player2_life = root.findViewById(R.id.player2_life);
        final ImageButton player2_lifeup =  root.findViewById(R.id.player2_lifeup);
        player2_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player2_life.setText(String.valueOf(Integer.valueOf(player2_life.getText().toString())+1));

            }
        });

        final ImageButton player2_lifedown =  root.findViewById(R.id.player2_lifedown);
        player2_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player2_life.getText().toString()) > 0)
                {
                    player2_life.setText(String.valueOf(Integer.valueOf(player2_life.getText().toString())-1));
                }
            }
        });

        // aumentar y disminuir vida jugador 3
        final TextView player3_life = root.findViewById(R.id.player3_life);
        final ImageButton player3_lifeup =  root.findViewById(R.id.player3_lifeup);
        player3_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player3_life.setText(String.valueOf(Integer.valueOf(player3_life.getText().toString())+1));

            }
        });

        final ImageButton player3_lifedown =  root.findViewById(R.id.player3_lifedown);
        player3_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player3_life.getText().toString()) > 0)
                {
                    player3_life.setText(String.valueOf(Integer.valueOf(player3_life.getText().toString())-1));
                }
            }
        });

        // aumentar y disminuir vida jugador 4
        final TextView player4_life = root.findViewById(R.id.player4_life);
        final ImageButton player4_lifeup =  root.findViewById(R.id.player4_lifeup);
        player4_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player4_life.setText(String.valueOf(Integer.valueOf(player4_life.getText().toString())+1));

            }
        });

        final ImageButton player4_lifedown =  root.findViewById(R.id.player4_lifedown);
        player4_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player4_life.getText().toString()) > 0)
                {
                    player4_life.setText(String.valueOf(Integer.valueOf(player4_life.getText().toString())-1));
                }
            }
        });

        // aumentar y disminuir vida jugador 5
        final TextView player5_life = root.findViewById(R.id.player5_life);
        final ImageButton player5_lifeup =  root.findViewById(R.id.player5_lifeup);
        player5_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player5_life.setText(String.valueOf(Integer.valueOf(player5_life.getText().toString())+1));

            }
        });

        final ImageButton player5_lifedown =  root.findViewById(R.id.player5_lifedown);
        player5_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player5_life.getText().toString()) > 0)
                {
                    player5_life.setText(String.valueOf(Integer.valueOf(player5_life.getText().toString())-1));
                }
            }
        });

        // aumentar y disminuir vida jugador 6
        final TextView player6_life = root.findViewById(R.id.player6_life);
        final ImageButton player6_lifeup =  root.findViewById(R.id.player6_lifeup);
        player6_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player6_life.setText(String.valueOf(Integer.valueOf(player6_life.getText().toString())+1));

            }
        });

        final ImageButton player6_lifedown =  root.findViewById(R.id.player6_lifedown);
        player6_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player6_life.getText().toString()) > 0)
                {
                    player6_life.setText(String.valueOf(Integer.valueOf(player6_life.getText().toString())-1));
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