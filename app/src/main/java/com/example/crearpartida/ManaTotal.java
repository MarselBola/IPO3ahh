package com.example.crearpartida;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ManaTotal extends AppCompatActivity implements View.OnClickListener{

    Button buttonAvaiable, buttonAdd;
    Globals player = Globals.getInstance();
    String background;
    TextView aux;
    ImageButton[] add, sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mana_total);
        int resID, id;
        add = new ImageButton[32];
        sub = new ImageButton[32];

        //visualitzo les files necessaries per a visualitzar el mana que tinc
        for(int i = 0; i < player.getPlayer().getPlayerMana().getRowTotal(); i++){
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
            aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getTotal());
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

        buttonAvaiable = findViewById(R.id.bAvaiable); //mana disponible
        buttonAvaiable.setOnClickListener(this);
        buttonAdd = findViewById(R.id.bAdd);           //add mana
        buttonAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int resID;
        if(v.getId() == R.id.bAvaiable){
            Intent toDisp = new Intent(this, ManaAvaiable.class);
            startActivity(toDisp);
            this.finish();
        }else if(v.getId() == R.id.bAdd){
            Intent toAddMana = new Intent(this, AddMana.class);
            startActivity(toAddMana);
            finish();
        }else{
            for(int i = 0; i < player.getPlayer().getPlayerMana().getQuantManaTotal(); i++) {
                resID = getResources().getIdentifier("add" + i,"id", getPackageName());
                if(v.getId() == resID){
                    player.getPlayer().getPlayerMana().getManaArray()[i].addOneToTotal();
                    resID = getResources().getIdentifier("quant" + i,"id", getPackageName());
                    aux = findViewById(resID);
                    aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getTotal());
                }
                resID = getResources().getIdentifier("sub" + i,"id", getPackageName());
                if(v.getId() == resID){
                    player.getPlayer().getPlayerMana().getManaArray()[i].subOneToTotal();
                    resID = getResources().getIdentifier("quant" + i,"id", getPackageName());
                    aux = findViewById(resID);
                    aux.setText("" + player.getPlayer().getPlayerMana().getManaArray()[i].getTotal());
                }
            }
        }
    }
}

