package com.example.crearpartida.dice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crearpartida.R;

import java.util.Random;

public class DausActivity extends AppCompatActivity implements View.OnClickListener{

    Button back, throwDau, predefinidos;
    Random r = new Random();
    TextView dau;
    EditText etcares;
    int rand, cares = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daus);

        predefinidos = findViewById(R.id.d2);
        predefinidos.setOnClickListener(this);
        predefinidos = findViewById(R.id.d4);
        predefinidos.setOnClickListener(this);
        predefinidos = findViewById(R.id.d6);
        predefinidos.setOnClickListener(this);
        predefinidos = findViewById(R.id.d8);
        predefinidos.setOnClickListener(this);
        predefinidos = findViewById(R.id.d12);
        predefinidos.setOnClickListener(this);
        predefinidos = findViewById(R.id.d20);
        predefinidos.setOnClickListener(this);
        back = findViewById(R.id.bDausBack);
        back.setOnClickListener(this);

        throwDau = findViewById(R.id.bThrow);
        throwDau.setOnClickListener(this);

        dau = findViewById(R.id.tResultatDau);

        etcares = findViewById(R.id.etCares);
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.bDausBack:
                Uri uri = Uri.parse(""+2);
                Intent canvi = new Intent(null, uri);
                setResult(RESULT_OK, canvi);
                this.finish();
                break;
            case R.id.d2:
                cares = 2;
                rand = r.nextInt(cares);
                dau.setText(String.valueOf(rand+1));
                break;
            case R.id.d4:
                cares = 4;
                rand = r.nextInt(cares);
                dau.setText(String.valueOf(rand+1));
                break;
            case R.id.d6:
                cares = 6;
                rand = r.nextInt(cares);
                dau.setText(String.valueOf(rand+1));
                break;
            case R.id.d8:
                cares = 8;
                rand = r.nextInt(cares);
                dau.setText(String.valueOf(rand+1));
                break;
            case R.id.d12:
                cares = 12;
                rand = r.nextInt(cares);
                dau.setText(String.valueOf(rand+1));
                break;
            case R.id.d20:
                cares = 20;
                rand = r.nextInt(cares);
                dau.setText(String.valueOf(rand+1));
                break;
            case R.id.bThrow:
                cares = Integer.parseInt(etcares.getText().toString());
                if(cares > 0){

                    rand = r.nextInt(cares);
                    dau.setText(String.valueOf(rand+1));
                }
                else
                    Toast.makeText(getApplicationContext(), "El nombre de cares ha de ser superior a 2", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
