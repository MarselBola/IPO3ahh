package com.example.crearpartida.pool;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        Fragment fragment= new ManaAvailable();
        ft.add(R.id.manafragment, fragment);
        ft.commit();

        return root;
    }

}