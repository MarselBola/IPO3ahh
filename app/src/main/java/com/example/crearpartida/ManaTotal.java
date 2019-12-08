package com.example.crearpartida;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ManaTotal extends Fragment implements View.OnClickListener{
    View root;
    Button buttonAvaiable, buttonAdd;
    Globals player = Globals.getInstance();
    String background;
    TextView aux;
    ImageButton[] add, sub;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.mana_total, container, false);


        int resID, id;
        add = new ImageButton[32];
        sub = new ImageButton[32];

        //visualitzo les files necessaries per a visualitzar el mana que tinc
        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowTotal(); i++){
            resID = getResources().getIdentifier("row" + i,"id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);
        }

        for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
            //visualitzo el mana que tinc en les files anteriors
            resID = getResources().getIdentifier("mana" + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);

            //obtinc el BackGround especific pel tipus de mana
            background = player.getPlayer().getPlayerMana().getManaArray()[i].getBackground();
            id = getResources().getIdentifier(background, "drawable", getActivity().getPackageName());
            root.findViewById(resID).setBackgroundResource(id);

            //visualitzo la quantitat de mana total
            resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
            aux = root.findViewById(resID);
            aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getTotal());
            aux.setTextColor(Color.WHITE);
            aux.setTextSize(30);

            //OnClickListeners dels botons de afegir i eliminar
            resID = getResources().getIdentifier("add" + i,"id", getActivity().getPackageName());
            add[i] = (ImageButton) root.findViewById(resID);
            add[i].setOnClickListener(this);
            resID = getResources().getIdentifier("sub" + i,"id", getActivity().getPackageName());
            sub[i] = (ImageButton) root.findViewById(resID);
            sub[i].setOnClickListener(this);
        }

        buttonAvaiable = root.findViewById(R.id.bAvailable); //mana disponible
        buttonAvaiable.setOnClickListener(this);
        buttonAdd = root.findViewById(R.id.bAdd);           //add mana
        buttonAdd.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v){
        int resID;
        if(v.getId() == R.id.bAvailable){
            Fragment manaavaliable = new ManaAvaliable();
            FragmentManager fm = getParentFragment().getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.manafragment, manaavaliable);
            fragmentTransaction.commit();
        }else if(v.getId() == R.id.bAdd){
            Fragment addmana = new AddMana();
            FragmentManager fm = getParentFragment().getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.manafragment, addmana);
            fragmentTransaction.commit();
        }else{
            for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
                resID = getResources().getIdentifier("add" + i,"id", getActivity().getPackageName());
                if(v.getId() == resID){
                    player.getPlayer().getPlayerMana().getManaArray()[i].addOneToTotal();
                    resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
                    aux = root.findViewById(resID);
                    aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getTotal());
                }
                resID = getResources().getIdentifier("sub" + i,"id", getActivity().getPackageName());
                if(v.getId() == resID){
                    player.getPlayer().getPlayerMana().getManaArray()[i].subOneToTotal();
                    resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
                    aux = root.findViewById(resID);
                    aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getTotal());
                }
            }
        }
    }
}

