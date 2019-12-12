package com.example.crearpartida.localroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.crearpartida.CrearPartida;
import com.example.crearpartida.Globals;
import com.example.crearpartida.InGame;
import com.example.crearpartida.Partida;
import com.example.crearpartida.R;

public class LocalRoom extends AppCompatActivity implements View.OnClickListener {
    Button botonSalir, botonIniciarPartida, botonAnadirJugador;
    Partida p= Globals.getInstance().getGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.local_room);

        // boton añadir jugador
        botonAnadirJugador= findViewById(R.id.addplayer_localroom);
        botonAnadirJugador.setOnClickListener(this);

        // lista de jugadores
        LinearLayout lista= findViewById(R.id.playerlist_localroom);
        int numJugadorsPartida= 0;
        for(int i=0; p.getNumJug()>i; i++)
        {
                ConstraintLayout usuario= new ConstraintLayout(this);
                lista.addView(usuario);
                TextView nombre= new TextView(this);
                nombre.setText(p.getJugadors()[i].getNom());
                usuario.addView(nombre);
                numJugadorsPartida++;
            }

        // boton iniciar partida
        botonIniciarPartida= findViewById(R.id.startgame_localroom);
        botonIniciarPartida.setOnClickListener(this);

        // boton salir
        botonSalir= findViewById(R.id.exitButton_localroom);
        botonSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.addplayer_localroom:
                Intent toAddPlayer = new Intent(this, AddPlayerToRoom.class);
                finish(); // cerrar actividad actual
                startActivity(toAddPlayer);
                break;
            case R.id.exitButton_localroom:
                Intent toCreateGame = new Intent(this, CrearPartida.class);
                finish(); // cerrar actividad actual
                startActivity(toCreateGame);
                break;
            case R.id.startgame_localroom:
                Intent toGame = new Intent(this, InGame.class);
                finish(); // cerrar actividad actual
                startActivity(toGame);
                break;
            default:
                break;
        }
    }
}
