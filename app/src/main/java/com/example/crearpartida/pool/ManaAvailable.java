package com.example.crearpartida.pool;

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

import com.example.crearpartida.clases.Globals;
import com.example.crearpartida.clases.Mana;
import com.example.crearpartida.R;

public class ManaAvailable extends Fragment implements View.OnClickListener{
    View root;
    private Button buttonTotal, buttonAccept, buttonReset, buttonFill;
    Globals player = Globals.getInstance();
    private String background;
    private TextView aux;
    private ImageButton[] add, sub;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                         @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.mana_available,container, false);
        int resID, id;
        add = new ImageButton[32];
        sub = new ImageButton[32];

        //visualitzo les files necessaries per a visualitzar el mana que tinc
        ShowRowsAvaiable();

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
        buttonFill = root.findViewById(R.id.bRellenar);
        buttonFill.setOnClickListener(this);
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
        for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
            //visualitzo el mana que tinc en les files anteriors
            resID = getResources().getIdentifier("mana" + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);

            //obtinc el BackGround especific pel tipus de mana
            background = player.getPlayer().getPlayerMana().getManaAvailable()[i].getBackground();
            id = getResources().getIdentifier(background, "drawable", getActivity().getPackageName());
            resID = getResources().getIdentifier("bg" + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setBackgroundResource(id);

            //visualitzo la quantitat de mana total
            resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
            aux = root.findViewById(resID);
            aux.setText("" + player.getPlayer().getPlayerMana().getManaCheckpoint()[i].getAvaiable());
            aux.setTextSize(30);

            //OnClickListeners dels botons de afegir i eliminar
            resID = getResources().getIdentifier("add" + i,"id", getActivity().getPackageName());
            add[i] = root.findViewById(resID);
            add[i].setOnClickListener(this);
            resID = getResources().getIdentifier("sub" + i,"id", getActivity().getPackageName());
            sub[i] = root.findViewById(resID);
            sub[i].setOnClickListener(this);
        }
    }

    private void ShowRowsSpending(){
        int resID;
        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowSpent(); i++){
            resID = getResources().getIdentifier("row0" + i,"id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);
        }
    }

    private void ShowManaSpending(){
        int resID, id;
        for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaSpent(); i++) {
            //visualitzo el mana que tinc en les files anteriors
            resID = getResources().getIdentifier("mana0" + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setVisibility(View.VISIBLE);

            //obtinc el BackGround especific pel tipus de mana
            background = player.getPlayer().getPlayerMana().getManaSpent()[i].getBackground();
            id = getResources().getIdentifier(background, "drawable", getActivity().getPackageName());
            resID = getResources().getIdentifier("bg0" + i, "id", getActivity().getPackageName());
            root.findViewById(resID).setBackgroundResource(id);

            //visualitzo la quantitat de mana total
            resID = getResources().getIdentifier("quant0" + i,"id", getActivity().getPackageName());
            aux = root.findViewById(resID);
            aux.setText("" + player.getPlayer().getPlayerMana().getManaSpent()[i].getTotal());
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

    @Override
    public void onClick(View v){
        int resID, id;
        if(v.getId() == R.id.bTotal){
            Fragment manatotal = new ManaTotal();
            FragmentManager fm = getParentFragment().getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.manafragment, manatotal);
            fragmentTransaction.commit();
        }else if(v.getId() == R.id.bAccept){
            //visualitzar tot el mana available i spending com a gone
            SetRowsAndManaInvisible(1);
            SetRowsAndManaInvisible(0);

            //crear nou checkpoint i buidar rowsSpending

            player.getPlayer().getPlayerMana().setManaCheckpoint(player.getPlayer().getPlayerMana().copyManaAvailable());
            player.getPlayer().getPlayerMana().setQuantManaSpent(0);
            player.getPlayer().getPlayerMana().setRowSpent(0);
            player.getPlayer().getPlayerMana().setManaSpent(new Mana[32]);

            //visualitzo les files necessaries per a visualitzar el mana que tinc
            ShowRowsAvaiable();

            //visualitzo el mana que tinc en les files anteriors i tot el que comporta
            ShowManaAvaiable();

        }else if(v.getId() == R.id.bReset) {
            //igualar la array de mana avaiable = array checkpoint
            player.getPlayer().getPlayerMana().setManaAvailable(player.getPlayer().getPlayerMana().copyCheckPoint());
            SetRowsAndManaInvisible(0);
            player.getPlayer().getPlayerMana().setQuantManaSpent(0);
            player.getPlayer().getPlayerMana().setRowSpent(0);
            player.getPlayer().getPlayerMana().setManaSpent(new Mana[32]);
            //visualitzo les files necessaries per a visualitzar el mana que tinc
            ShowRowsAvaiable();

            //visualitzo el mana que tinc en les files anteriors i tot el que comporta
            ShowManaAvaiable();
        }else if(v.getId() == R.id.bRellenar){
            SetRowsAndManaInvisible(1);
            player.getPlayer().getPlayerMana().setManaAvailable(player.getPlayer().getPlayerMana().copyManaTotal());
            player.getPlayer().getPlayerMana().setManaCheckpoint(player.getPlayer().getPlayerMana().copyManaTotal());
            ShowRowsAvaiable();
            ShowManaAvaiable();
        }else{
            for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
                resID = getResources().getIdentifier("add" + i,"id", getActivity().getPackageName());
                if(v.getId() == resID){

                    player.getPlayer().getPlayerMana().getManaAvailable()[i].addOneToAvaiable();

                    resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
                    aux = root.findViewById(resID);
                    aux.setText("" + player.getPlayer().getPlayerMana().getManaAvailable()[i].getAvaiable());
                }
                resID = getResources().getIdentifier("sub" + i,"id", getActivity().getPackageName());
                if(v.getId() == resID){
                    if(player.getPlayer().getPlayerMana().getManaAvailable()[i].getAvaiable() > 0 ){
                        player.getPlayer().getPlayerMana().getManaAvailable()[i].subOneToAvaiable();
                        resID = getResources().getIdentifier("quant" + i,"id", getActivity().getPackageName());
                        aux = root.findViewById(resID);
                        aux.setText("" + player.getPlayer().getPlayerMana().getManaAvailable()[i].getAvaiable());

                        int pos = player.getPlayer().getPlayerMana().getManaPosition(
                                player.getPlayer().getPlayerMana().getManaAvailable()[i],
                                player.getPlayer().getPlayerMana().getManaSpent(),
                                player.getPlayer().getPlayerMana().getQuantManaSpent());
                        if(pos == -1){  //no esta dins dels spending
                            player.getPlayer().getPlayerMana().addManaAtSpent(player.getPlayer().getPlayerMana().getManaAvailable()[i].Copy());

                            resID = getResources().getIdentifier("row0" + (player.getPlayer().getPlayerMana().getRowSpent()-1),"id", getActivity().getPackageName());
                            root.findViewById(resID).setVisibility(View.VISIBLE);

                            //visualitzo el mana que tinc en les files anteriors
                            resID = getResources().getIdentifier("mana0" + (player.getPlayer().getPlayerMana().getQuantManaSpent()-1), "id", getActivity().getPackageName());
                            root.findViewById(resID).setVisibility(View.VISIBLE);

                            //obtinc el BackGround especific pel tipus de mana
                            background = player.getPlayer().getPlayerMana().getManaAvailable()[i].getBackground();
                            id = getResources().getIdentifier(background, "drawable", getActivity().getPackageName());
                            resID = getResources().getIdentifier("bg0" + i, "id", getActivity().getPackageName());
                            root.findViewById(resID).setBackgroundResource(id);

                            //visualitzo la quantitat de mana total
                            resID = getResources().getIdentifier("quant0" + i,"id", getActivity().getPackageName());
                            aux = root.findViewById(resID);
                            aux.setText("" + player.getPlayer().getPlayerMana().getManaSpent()[i].getTotal());
                            aux.setTextSize(30);
                        }
                        else {
                            player.getPlayer().getPlayerMana().getManaSpent()[pos].addOneToTotal();
                            resID = getResources().getIdentifier("quant0" + pos, "id", getActivity().getPackageName());
                            aux = root.findViewById(resID);
                            aux.setText("" + player.getPlayer().getPlayerMana().getManaSpent()[pos].getTotal());
                        }
                    }
                }
            }
        }
    }
}
