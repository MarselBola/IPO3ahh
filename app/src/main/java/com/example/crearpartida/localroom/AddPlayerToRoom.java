package com.example.crearpartida.localroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.crearpartida.Globals;
import com.example.crearpartida.Partida;
import com.example.crearpartida.R;

import java.util.Map;

public class AddPlayerToRoom extends AppCompatActivity implements View.OnClickListener {
    Button botonSalir;
    Partida p= Globals.getInstance().getGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_player_to_room);

        // shared preferences
        SharedPreferences prefs= getSharedPreferences("listaUsuarios", Context.MODE_PRIVATE);

        // imprimimos todos los nombres de la lista de usuarios
        TableLayout userList= findViewById(R.id.userList_addplayertoroom);
        int numUsuarios= 0;
        TableRow user;
        Map<String, ?> keys= prefs.getAll();
        for(Map.Entry<String, ?> entry : keys.entrySet())
        {
            user= new TableRow(this);
            userList.addView(user, numUsuarios);
            TextView textUser= new TextView(this);
            textUser.setText(entry.getValue().toString());
            textUser.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
            textUser.setPadding(0,0,50,0);
            user.addView(textUser);
            Button addUser= new Button(this);
            final String name= entry.getValue().toString();
            addUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    boolean trobat= false;
                    int i= 0;
                    while((!trobat) && (i<p.getNumJug()))
                    {
                        if(p.getJugadors()[i].getNom().equals("empty"))
                        {
                            trobat= true;
                        }
                        else
                        {
                            i++;
                        }
                    }
                    if(trobat)
                    {
                        p.getJugadors()[i].setNom(name);
                    }
                    Intent toLocalRoom = new Intent(getApplicationContext(), LocalRoom.class);
                    finish(); // cerrar actividad actual
                    startActivity(toLocalRoom);
                }
            });
            addUser.setText("ADD");
            user.addView(addUser);
            numUsuarios++;
        }

        // boton salir
        botonSalir= findViewById(R.id.exitButton_addplayertoroom);
        botonSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.exitButton_addplayertoroom:
                Intent toLocalRoom = new Intent(this, LocalRoom.class);
                finish(); // cerrar actividad actual
                startActivity(toLocalRoom);
                break;
            default:
                break;
        }
    }
}
