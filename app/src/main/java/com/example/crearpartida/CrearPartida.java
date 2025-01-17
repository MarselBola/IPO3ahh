package com.example.crearpartida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.crearpartida.clases.Globals;
import com.example.crearpartida.clases.Partida;

import com.example.crearpartida.localroom.LocalRoom;


public class CrearPartida extends AppCompatActivity implements View.OnClickListener {

    Spinner sformat,sjugadors;
    Button vida20,vida30,vida40,back,start;
    EditText custom;
    boolean vidaConfig = false;
    int vida;
    int numJugadors;
    String format;
    Partida partida = new Partida();
    Globals g = Globals.getInstance();
    ArrayAdapter<CharSequence> adapterFormat,adapterJug;
    AdapterView<?> adapterViewFormat, adapterViewJugador;
    int posFor,posJug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_partida);
        back = findViewById(R.id.bback);
        back.setOnClickListener(this);

        start = findViewById(R.id.bstart);
        start.setOnClickListener(this);

        vida20 = findViewById(R.id.bvida20);
        vida20.setOnClickListener(this);

        vida30 = findViewById(R.id.bvida30);
        vida30.setOnClickListener(this);

        vida40 = findViewById(R.id.bvida40);
        vida40.setOnClickListener(this);

        custom = findViewById(R.id.eCustomVida);

        sformat = findViewById(R.id.sFormat);
        String[] selJugadores = new String[]{
                "1",
                "2",
                "3",
                "4",
                "5",
                "6"
        };
        String[] selFormatos = new String[]{

                "Normal",
                "Commander"
        };
        ArrayAdapter<String> arrayAdapterFormatos = new ArrayAdapter<String>(this, R.layout.spinner_item, selFormatos);
        arrayAdapterFormatos.setDropDownViewResource(R.layout.spinner_item);
        sformat.setAdapter(arrayAdapterFormatos);



        sformat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(parent.getContext(), "Jugadors seleccionats: "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                adapterViewFormat = parent;
                posFor = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sjugadors = findViewById(R.id.sJugadors);
        ArrayAdapter<String> arrayAdapterJugadores = new ArrayAdapter<String>(this, R.layout.spinner_item, selJugadores);
        arrayAdapterJugadores.setDropDownViewResource(R.layout.spinner_item);
        sjugadors.setAdapter(arrayAdapterJugadores);

        sjugadors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(parent.getContext(), "Jugadors seleccionats: "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                adapterViewJugador = parent;
                posJug = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bstart:
                if((!vidaConfig)&&(custom.getText().length()==0)){
                    Toast.makeText(getApplicationContext(),"Primero debes indicar la vida incial",Toast.LENGTH_LONG).show();
                }else{
                    format = adapterViewFormat.getItemAtPosition(posFor).toString();
                    numJugadors = Integer.valueOf(adapterViewJugador.getItemAtPosition(posJug).toString());
                    if(!(custom.getText().length()==0)){
                        vida=Integer.parseInt(custom.getText().toString());
                    }
                    partida.setNumJug(numJugadors);
                    partida.setFormat(format);
                    partida.setDefaultNamesWHP(vida);
                    g.setGame(partida);

                    Intent toLocalRoom= new Intent(this, LocalRoom.class);
                    finish(); // cerrar actividad actual
                    startActivity(toLocalRoom);
                }
                break;
            case R.id.bback:
                finish();
                break;
            case R.id.bvida20:
                vidaConfig = true;
                vida =20;
                custom.setText(String.valueOf(vida));
                break;
            case R.id.bvida30:
                vidaConfig = true;
                vida =30;
                custom.setText(String.valueOf(vida));
                break;
            case R.id.bvida40:
                vidaConfig = true;
                vida =40;
                custom.setText(String.valueOf(vida));
                break;
            default:
                break;
        }
    }
}
