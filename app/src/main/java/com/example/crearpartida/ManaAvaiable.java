package com.example.crearpartida;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ManaAvaiable extends AppCompatActivity implements View.OnClickListener{

    Button buttonTotal, buttonAccept, buttonReset, buttonSpent, buttonMenu;
    Globals player = Globals.getInstance();
    String background;
    TextView aux;
    ImageButton[] add, sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mana_avaiable);
        int resID, id;
        add = new ImageButton[32];
        sub = new ImageButton[32];

        //visualitzo les files necessaries per a visualitzar el mana que tinc
        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowAvaiable(); i++){
            resID = getResources().getIdentifier("row" + i,"id", getPackageName());
            findViewById(resID).setVisibility(View.VISIBLE);
        }

        for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
            //visualitzo el mana que tinc en les files anteriors
            resID = getResources().getIdentifier("mana" + i, "id", getPackageName());
            findViewById(resID).setVisibility(View.VISIBLE);

            //obtinc el BackGround especific pel tipus de mana
            background = player.getPlayer().getPlayerMana().getManaArray()[i].getBackground();
            id = getResources().getIdentifier(background, "drawable", getPackageName());
            findViewById(resID).setBackgroundResource(id);

            //visualitzo la quantitat de mana total
            resID = getResources().getIdentifier("quant" + i,"id", getPackageName());
            aux = findViewById(resID);
            aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable());
            aux.setTextColor(Color.WHITE);
            aux.setTextSize(30);

            //OnClickListeners dels botons de afegir i eliminar
            resID = getResources().getIdentifier("add" + i,"id", getPackageName());
            add[i] = (ImageButton) findViewById(resID);
            add[i].setOnClickListener(this);
            resID = getResources().getIdentifier("sub" + i,"id", getPackageName());
            sub[i] = (ImageButton) findViewById(resID);
            sub[i].setOnClickListener(this);
        }

        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowSpent(); i++){
            resID = getResources().getIdentifier("row0" + i,"id", getPackageName());
            findViewById(resID).setVisibility(View.VISIBLE);
        }

        for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaSpent(); i++) {
            //visualitzo el mana que tinc en les files anteriors
            resID = getResources().getIdentifier("manaWasted" + i, "id", getPackageName());
            findViewById(resID).setVisibility(View.VISIBLE);

            //obtinc el BackGround especific pel tipus de mana
            background = player.getPlayer().getPlayerMana().getManaSpent()[i].getBackground();
            id = getResources().getIdentifier(background, "drawable", getPackageName());
            findViewById(resID).setBackgroundResource(id);

            //visualitzo la quantitat de mana total
            resID = getResources().getIdentifier("quantWasted" + i,"id", getPackageName());
            aux = findViewById(resID);
            aux.setText("" + player.getPlayer().getPlayerMana().getManaSpent()[i].getTotal());
            aux.setTextColor(Color.WHITE);
            aux.setTextSize(30);
        }

        buttonTotal = (Button) findViewById(R.id.bTotal);
        buttonTotal.setOnClickListener(this);
        buttonAccept= (Button) findViewById(R.id.bAccept);
        buttonAccept.setOnClickListener(this);
        buttonReset= (Button) findViewById(R.id.bReset);
        buttonReset.setOnClickListener(this);
        buttonSpent= (Button) findViewById(R.id.bSpent);
        buttonSpent.setOnClickListener(this);
        buttonMenu= (Button) findViewById(R.id.bMenu);
        buttonMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int resID, id;
        if(v.getId() == R.id.bTotal){
            Intent toTotal = new Intent(this, ManaTotal.class);
            startActivity(toTotal);
            finish();
        }else if(v.getId() == R.id.bMenu) {
            this.finish();
        }else if(v.getId() == R.id.bAccept){

        }else if(v.getId() == R.id.bReset){
            //igualar la array de mana avaiable = array checkpoint
        }else if(v.getId() == R.id.bSpent){
            //visualitzar l'historial de mana gastat
            //startActivity(afegirMana);
        }else{
            for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
                resID = getResources().getIdentifier("add" + i,"id", getPackageName());
                if(v.getId() == resID){
                    player.getPlayer().getPlayerMana().getManaArray()[i].addOneToAvaiable();
                    resID = getResources().getIdentifier("quant" + i,"id", getPackageName());
                    aux = findViewById(resID);
                    aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable());
                }
                resID = getResources().getIdentifier("sub" + i,"id", getPackageName());
                if(v.getId() == resID){
                    if(player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable() > 0 ){
                        player.getPlayer().getPlayerMana().getManaArray()[i].subOneToAvaiable();
                        resID = getResources().getIdentifier("quant" + i,"id", getPackageName());
                        aux = findViewById(resID);
                        aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getAvaiable());

                        int pos = player.getPlayer().getPlayerMana().getManaPosition(
                                player.getPlayer().getPlayerMana().getManaArray()[i],
                                player.getPlayer().getPlayerMana().getManaSpent(),
                                player.getPlayer().getPlayerMana().getQuantManaSpent());
                        if(pos == -1){
                            player.getPlayer().getPlayerMana().addManaAtSpent(player.getPlayer().getPlayerMana().getManaArray()[i].Copy());
                            player.getPlayer().getPlayerMana().getManaSpent()[player.getPlayer().getPlayerMana().getQuantManaSpent()-1].setTotal(1);


                            resID = getResources().getIdentifier("row0" + (player.getPlayer().getPlayerMana().getRowSpent()-1),"id", getPackageName());
                            findViewById(resID).setVisibility(View.VISIBLE);

                            resID = getResources().getIdentifier("manaWasted" + (player.getPlayer().getPlayerMana().getQuantManaSpent()-1), "id", getPackageName());
                            findViewById(resID).setVisibility(View.VISIBLE);

                            //obtinc el BackGround especific pel tipus de mana
                            background = player.getPlayer().getPlayerMana().getManaSpent()[i].getBackground();
                            id = getResources().getIdentifier(background, "drawable", getPackageName());
                            findViewById(resID).setBackgroundResource(id);

                            //visualitzo la quantitat de mana total
                            resID = getResources().getIdentifier("quantWasted" + (player.getPlayer().getPlayerMana().getQuantManaSpent()-1),"id", getPackageName());
                            aux = findViewById(resID);
                            aux.setText("1");
                            aux.setTextColor(Color.WHITE);
                            aux.setTextSize(30);
                        }
                        else {
                            player.getPlayer().getPlayerMana().getManaSpent()[pos].addOneToTotal();
                            resID = getResources().getIdentifier("quantWasted" + pos, "id", getPackageName());
                            aux = findViewById(resID);
                            int debug = player.getPlayer().getPlayerMana().getManaSpent()[pos].getTotal();
                            aux.setText("" + debug);
                        }
                    }
                }
            }
        }
    }
}
