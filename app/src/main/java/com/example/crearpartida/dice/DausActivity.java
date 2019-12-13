package com.example.crearpartida.dice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crearpartida.R;

import java.util.Random;

public class DausActivity extends AppCompatActivity implements View.OnClickListener{

    Button back, throwDau;
    ImageButton predefinidos;
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
                etcares.setText(String.valueOf(2));
                break;
            case R.id.d4:
                etcares.setText(String.valueOf(4));
                break;
            case R.id.d6:
                etcares.setText(String.valueOf(6));
                break;
            case R.id.d8:
                etcares.setText(String.valueOf(8));
                break;
            case R.id.d12:
                etcares.setText(String.valueOf(12));
                break;
            case R.id.d20:
                etcares.setText(String.valueOf(20));
                break;
            case R.id.bThrow:
                cares = Integer.parseInt(etcares.getText().toString());
                if(cares > 0){

                    rand = r.nextInt(cares);
                    dau.setText(String.valueOf(rand+1));
                }
                else
                    Toast.makeText(getApplicationContext(), "El nombre de caras ha de ser superior a 2", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
