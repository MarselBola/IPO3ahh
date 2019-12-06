package com.example.crearpartida.pool;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.crearpartida.*;

public class PoolFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pool, container, false);

        FragmentManager fm= getChildFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        Fragment fragment= new ManaAvaliable();
        ft.add(R.id.manaavaliable, fragment);
        ft.commit();

        return root;
    }

}