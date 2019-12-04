package com.example.crearpartida.exit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.crearpartida.*;

public class ExitFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exit, container, false);

        Intent toStart = new Intent(getActivity(), StartMenu.class);
        getActivity().finish(); // cerrar actividad actual
        startActivity(toStart);
        return root;
    }

}