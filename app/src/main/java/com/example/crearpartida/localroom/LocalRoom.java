package com.example.crearpartida.localroom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
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

        // lista de jugadores
        TableLayout lista= findViewById(R.id.userlist_localroom);
        TableRow jugador;
        int numJugadorsPartida;
        for(numJugadorsPartida=0; p.getNumJug()>numJugadorsPartida; numJugadorsPartida++)
        {
                jugador= new TableRow(this);
                lista.addView(jugador, numJugadorsPartida);
                TextView nombre= new TextView(this);
                nombre.setText(p.getJugadors()[numJugadorsPartida].getNom());
                nombre.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
                nombre.setPadding(0,0,50,0);
                jugador.addView(nombre);
                Button editPlayer= new Button(this);
                editPlayer.setText("EDIT");
                final int id= numJugadorsPartida;
                editPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toAddPlayer = new Intent(getApplicationContext(), AddPlayerToRoom.class);
                        toAddPlayer.putExtra("id", id); // enviammos la id a AddPlayerToRoom para que sepa que usuario cambiar de la lista de jugadores.
                        startActivity(toAddPlayer);
                    }
                });
                jugador.addView(editPlayer);
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
