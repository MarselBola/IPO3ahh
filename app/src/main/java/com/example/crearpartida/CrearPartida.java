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
        adapterFormat = ArrayAdapter.createFromResource(this, R.array.combo_format, android.R.layout.simple_spinner_item);
        sformat.setAdapter(adapterFormat);
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
        adapterJug = ArrayAdapter.createFromResource(this, R.array.combo_jugadors, android.R.layout.simple_spinner_item);
        sjugadors.setAdapter(adapterJug);
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
                    Intent start = new Intent(this, InGame.class);
                    startActivity(start);

                }
                break;
            case R.id.bback:
                finish();
                break;
            case R.id.bvida20:
                vidaConfig = true;
                vida =20;
                break;
            case R.id.bvida30:
                vidaConfig = true;
                vida =30;
                break;
            case R.id.bvida40:
                vidaConfig = true;
                vida =40;
                break;

        }
    }
}
