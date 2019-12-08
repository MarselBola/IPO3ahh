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
import com.example.crearpartida.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ManaAvaliable extends Fragment implements View.OnClickListener{
    View root;
    Button buttonTotal, buttonAccept, buttonReset, buttonSpent, buttonMenu;
    Globals player = Globals.getInstance();
    String background;
    TextView aux;
    ImageButton[] add, sub;

    @Nullable
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/ManaAvailable.java
    public View onCreateView(@NonNull LayoutInflater inflater,
                         @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.mana_available,container, false);
=======
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mana_avaliable, container, false);
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/pool/ManaAvaliable.java
        int resID, id;
        add = new ImageButton[32];
        sub = new ImageButton[32];

        //visualitzo les files necessaries per a visualitzar el mana que tinc
        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowAvaiable(); i++){
            resID = getResources().getIdentifier("row" + i,"id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);
        }

<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/ManaAvailable.java
        //visualitzo el mana que tinc en les files anteriors i tot el que comporta
        ShowManaAvaiable();

        //visualitzo les files del mana que s'esta gastant
        ShowRowsSpending();

        //visualitzo el mana que s'esta gastant
        ShowManaSpending();

        buttonTotal = root.findViewById(R.id.bTotal);
        buttonTotal.setOnClickListener(this);
        buttonAccept= root.findViewById(R.id.bAccept);
        buttonAccept.setOnClickListener(this);
        buttonReset= root.findViewById(R.id.bReset);
        buttonReset.setOnClickListener(this);

        return root;
    }

    private void ShowRowsAvaiable(){
        int resID;
        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowAvailable(); i++){
            resID = getResources().getIdentifier("row" + i,"id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);
        }
    }

    private void ShowManaAvaiable(){
        int resID, id;
=======
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/pool/ManaAvaliable.java
        for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
            //visualitzo el mana que tinc en les files anteriors
            resID = getResources().getIdentifier("mana" + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);

            //obtinc el BackGround especific pel tipus de mana
            background = player.getPlayer().getPlayerMana().getManaAvailable()[i].getBackground();
            id = getResources().getIdentifier(background, "drawable", getActivity().getPackageName());
            root.findViewById(resID).setBackgroundResource(id);

            //visualitzo la quantitat de mana total
            resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
            aux = root.findViewById(resID);
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/ManaAvailable.java
            aux.setText("" + player.getPlayer().getPlayerMana().getManaAvailable()[i].getTotal());
=======
            aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable());
            aux.setTextColor(Color.WHITE);
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/pool/ManaAvaliable.java
            aux.setTextSize(30);

            //OnClickListeners dels botons de afegir i eliminar
            resID = getResources().getIdentifier("add" + i,"id", getActivity().getPackageName());
            add[i] = (ImageButton) root.findViewById(resID);
            add[i].setOnClickListener(this);
            resID = getResources().getIdentifier("sub" + i,"id", getActivity().getPackageName());
            sub[i] = (ImageButton) root.findViewById(resID);
            sub[i].setOnClickListener(this);
        }
    }

<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/ManaAvailable.java
    private void ShowRowsSpending(){
        int resID;
=======
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/pool/ManaAvaliable.java
        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowSpent(); i++){
            resID = getResources().getIdentifier("row0" + i,"id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);
        }
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/ManaAvailable.java
    }
=======
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/pool/ManaAvaliable.java

    private void ShowManaSpending(){
        int resID, id;
        for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaSpent(); i++) {
            //visualitzo el mana que tinc en les files anteriors
            resID = getResources().getIdentifier("manaWasted" + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);

            //obtinc el BackGround especific pel tipus de mana
            background = player.getPlayer().getPlayerMana().getManaSpent()[i].getBackground();
            id = getResources().getIdentifier(background, "drawable", getActivity().getPackageName());
            root.findViewById(resID).setBackgroundResource(id);

            //visualitzo la quantitat de mana total
            resID = getResources().getIdentifier("quantWasted" + i,"id", getActivity().getPackageName());
            aux = root.findViewById(resID);
            aux.setText("" + player.getPlayer().getPlayerMana().getManaSpent()[i].getTotal());
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/ManaAvailable.java
            aux.setTextSize(30);
        }
    }

    private void SetRowsAndManaInvisible(int num){ //   0 = spending, 1 = available
        int resID;
        String aux;

        if(num == 0) aux = "row0";
        else aux = "row";

        for(int i = 0; i < 15; i++){
            resID = getResources().getIdentifier(aux + i,"id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.GONE);
        }

        if(num == 0) aux = "mana0";
        else aux = "mana";

        for(int i = 0; i < 31; i++) {
            resID = getResources().getIdentifier(aux + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.GONE);
        }
    }

=======
            aux.setTextColor(Color.WHITE);
            aux.setTextSize(30);
        }

        buttonTotal = (Button) root.findViewById(R.id.bTotal);
        buttonTotal.setOnClickListener(this);
        buttonAccept= (Button) root.findViewById(R.id.bAccept);
        buttonAccept.setOnClickListener(this);
        buttonReset= (Button) root.findViewById(R.id.bReset);
        buttonReset.setOnClickListener(this);
        buttonSpent= (Button) root.findViewById(R.id.bSpent);
        buttonSpent.setOnClickListener(this);
        buttonMenu= (Button) root.findViewById(R.id.bMenu);
        buttonMenu.setOnClickListener(this);
        return root;
    }

>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/pool/ManaAvaliable.java
    @Override
    public void onClick(View v){
        int resID, id;
        if(v.getId() == R.id.bTotal){
            Fragment manatotal = new ManaTotal();
            FragmentManager fm = getParentFragment().getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.manafragment, manatotal);
            fragmentTransaction.commit();
        }else if(v.getId() == R.id.bMenu) {
            //this.finish();
        }else if(v.getId() == R.id.bAccept){
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/ManaAvailable.java
            //visualitzar tot el mana available i spending com a gone
            SetRowsAndManaInvisible(1);
            SetRowsAndManaInvisible(0);

            //crear nou checkpoint i buidar rowsSpending
            player.getPlayer().getPlayerMana().setManaCheckpoint(player.getPlayer().getPlayerMana().getManaAvailable());
            player.getPlayer().getPlayerMana().setQuantManaSpent(0);
            player.getPlayer().getPlayerMana().setRowSpent(0);
            player.getPlayer().getPlayerMana().setManaSpent(new Mana[32]);

            //visualitzo les files necessaries per a visualitzar el mana que tinc
            ShowRowsAvaiable();

            //visualitzo el mana que tinc en les files anteriors i tot el que comporta
            ShowManaAvaiable();

        }else if(v.getId() == R.id.bReset){
            //igualar la array de mana avaiable = array checkpoint
            player.getPlayer().getPlayerMana().setManaAvailable(player.getPlayer().getPlayerMana().getManaCheckpoint());

            //visualitzo les files necessaries per a visualitzar el mana que tinc
            ShowRowsAvaiable();

            //visualitzo el mana que tinc en les files anteriors i tot el que comporta
            ShowManaAvaiable();

=======

        }else if(v.getId() == R.id.bReset){
            //igualar la array de mana avaiable = array checkpoint
        }else if(v.getId() == R.id.bSpent){
            //visualitzar l'historial de mana gastat
            //startActivity(afegirMana);
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/pool/ManaAvaliable.java
        }else{
            for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
                resID = getResources().getIdentifier("add" + i,"id", getActivity().getPackageName());
                if(v.getId() == resID){
                    player.getPlayer().getPlayerMana().getManaArray()[i].addOneToAvaiable();
                    resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
                    aux = getView().findViewById(resID);
                    aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable());
                }
                resID = getResources().getIdentifier("sub" + i,"id", getActivity().getPackageName());
                if(v.getId() == resID){
                    if(player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable() > 0 ){
                        player.getPlayer().getPlayerMana().getManaArray()[i].subOneToAvaiable();
                        resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
                        aux = getView().findViewById(resID);
                        aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable());

                        int pos = player.getPlayer().getPlayerMana().getManaPosition(
                                player.getPlayer().getPlayerMana().getManaArray()[i],
                                player.getPlayer().getPlayerMana().getManaSpent(),
                                player.getPlayer().getPlayerMana().getQuantManaSpent());
                        if(pos == -1){
                            player.getPlayer().getPlayerMana().addManaAtSpent(player.getPlayer().getPlayerMana().getManaArray()[i].Copy());
                            player.getPlayer().getPlayerMana().getManaSpent()[player.getPlayer().getPlayerMana().getQuantManaSpent()-1].setTotal(1);


                            resID = getResources().getIdentifier("row0" + (player.getPlayer().getPlayerMana().getRowSpent()-1),"id", getActivity().getPackageName());
                            getView().findViewById(resID).setVisibility(View.VISIBLE);

                            resID = getResources().getIdentifier("manaWasted" + (player.getPlayer().getPlayerMana().getQuantManaSpent()-1), "id", getActivity().getPackageName());
                            getView().findViewById(resID).setVisibility(View.VISIBLE);

                            //obtinc el BackGround especific pel tipus de mana
                            background = player.getPlayer().getPlayerMana().getManaSpent()[i].getBackground();
                            id = getResources().getIdentifier(background, "drawable", getActivity().getPackageName());
                            getView().findViewById(resID).setBackgroundResource(id);

                            //visualitzo la quantitat de mana total
                            resID = getResources().getIdentifier("quantWasted" + (player.getPlayer().getPlayerMana().getQuantManaSpent()-1),"id", getActivity().getPackageName());
                            aux = getView().findViewById(resID);
                            aux.setText("1");
                            aux.setTextColor(Color.WHITE);
                            aux.setTextSize(30);
                        }
                        else {
                            player.getPlayer().getPlayerMana().getManaSpent()[pos].addOneToTotal();
                            resID = getResources().getIdentifier("quantWasted" + pos, "id", getActivity().getPackageName());
                            aux = getView().findViewById(resID);
                            int debug = player.getPlayer().getPlayerMana().getManaSpent()[pos].getTotal();
                            aux.setText("" + debug);
                        }
                    }
                }
            }
        }
    }
}