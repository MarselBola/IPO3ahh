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
public class GameSixplayers extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.game_sixplayers, container, false);

        // aumentar y disminuir vida jugador 1
        final TextView player1_life = root.findViewById(R.id.player1_life);
        final ImageButton player1_lifeup =  root.findViewById(R.id.player1_lifeup);
        player1_lifeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player1_life.setText(String.valueOf(Integer.valueOf(player1_life.getText().toString())+1));

            }
        });

        final ImageButton player1_lifedown =  root.findViewById(R.id.player1_lifedown);
        player1_lifedown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.valueOf(player1_life.getText().toString()) > 0)
                {
                    player1_life.setText(String.valueOf(Integer.valueOf(player1_life.getText().toString())-1));
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