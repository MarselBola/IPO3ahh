package com.example.crearpartida.userlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.crearpartida.R;

public class CreateUser extends AppCompatActivity  implements View.OnClickListener {
    Button botonSalir, botonCrearUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        // boton crear usuario
        botonCrearUsuario= findViewById(R.id.createUserButton2);
        botonCrearUsuario.setOnClickListener(this);

        // boton salir
        botonSalir= findViewById(R.id.exitButtonCreateUser);
        botonSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent toUserList = new Intent(this, UserList.class);
        switch(v.getId())
        {
            case R.id.createUserButton2:
                SharedPreferences prefs= getSharedPreferences("listaUsuarios", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= prefs.edit();
                EditText nombre= findViewById(R.id.name_CreateUser);
                editor.putString(String.valueOf((int) (Math.random() * 999) + 1), nombre.getText().toString());
                editor.commit();
                finish(); // cerrar actividad actual
                startActivity(toUserList);
                break;
            case R.id.exitButtonCreateUser:
                finish(); // cerrar actividad actual
                startActivity(toUserList);
                break;
            default:
                break;
        }
    }
}
