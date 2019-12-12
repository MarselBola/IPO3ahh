package com.example.crearpartida.localroom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.crearpartida.R;

public class AddPlayerToRoom extends AppCompatActivity implements View.OnClickListener {
    Button botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_player_to_room);

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
