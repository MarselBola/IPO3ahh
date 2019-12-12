package com.example.crearpartida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crearpartida.dice.DausActivity;
import com.example.crearpartida.userlist.UserList;

public class StartMenu extends AppCompatActivity implements View.OnClickListener {

    Button botonComencar, botonDaus, botonHist, botonJug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu);

        botonComencar= findViewById(R.id.bComencar);
        botonComencar.setOnClickListener(this);
        botonDaus= findViewById(R.id.bDaus);
        botonDaus.setOnClickListener(this);
        botonHist= findViewById(R.id.bHistorial);
        botonHist.setOnClickListener(this);
        botonJug= findViewById(R.id.bJugadors);
        botonJug.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent game = new Intent(this, CrearPartida.class);
        Intent daus = new Intent(this, DausActivity.class);
        Intent jugadors= new Intent(this, UserList.class);

        switch (v.getId()){
            case R.id.bComencar:
                //Toast.makeText(getApplicationContext(), "Boto Començar", Toast.LENGTH_SHORT).show();
                startActivity(game);
                break;
            case R.id.bDaus:
                //Toast.makeText(getApplicationContext(), "Boto Daus", Toast.LENGTH_SHORT).show();
                startActivity(daus);
                break;
            case R.id.bHistorial:
                //Toast.makeText(getApplicationContext(), "Boto Historial", Toast.LENGTH_SHORT).show();
                //startActivity(historial);
                break;
            case R.id.bJugadors:
                //Toast.makeText(getApplicationContext(), "Boto Jugadors", Toast.LENGTH_SHORT).show();
                startActivity(jugadors);
                break;
            default:
                break;
        }
    }
}
