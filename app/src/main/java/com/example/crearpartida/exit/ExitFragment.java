package com.example.crearpartida.exit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.crearpartida.R;
import com.example.crearpartida.StartMenu;

public class ExitFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exit, container, false);

        Button exit = (Button) root.findViewById(R.id.salir_partida);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStart = new Intent(getActivity(), StartMenu.class);
                startActivity(toStart);
            }
        });
        return root;
    }

}