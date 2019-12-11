package com.example.crearpartida.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.crearpartida.R;
import com.example.crearpartida.StartMenu;

import java.util.Map;

public class UserList extends AppCompatActivity implements View.OnClickListener {
    Button botonSalir, botonCrearUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);

        // shared preferences
        SharedPreferences prefs= getSharedPreferences("listaUsuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();

        // pruebo valores
        editor.putString("1", "Joel");
        editor.putString("2", "Joan");
        editor.putString("3", "Alex");
        editor.putString("4", "Anna");

        // enviar cambios
        editor.commit();

        // para obtener un usuario con su id ("id a buscar", "valor si no se encuentra)
        //String usuari= prefs.getString("usuari1", "no@no.com");

        // para eliminar un usuario con su id
        //editor.remove("1");

        // para limpiar las shared preferences
        // editor.clear();

        // imprimimos todos los nombres en la lista de usuarios
        TableLayout userList= findViewById(R.id.userList);
        int numUsuarios= 0;
        TableRow user;
        Map<String, ?> keys= prefs.getAll();
        for(Map.Entry<String, ?> entry : keys.entrySet())
        {
            user= new TableRow(this);
            userList.addView(user, numUsuarios);
            TextView idUser= new TextView(this);
            idUser.setText(entry.getKey());
            idUser.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
            idUser.setPadding(0,0,50,0);
            user.addView(idUser);
            TextView textUser= new TextView(this);
            textUser.setText(entry.getValue().toString());
            textUser.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
            textUser.setPadding(0,0,50,0);
            user.addView(textUser);
            Button deleteUser= new Button(this);
            deleteUser.setOnClickListener(this);
            deleteUser.setText("DEL");
            user.addView(deleteUser);
            numUsuarios++;
        }
        System.out.println("numero usuarios: " + numUsuarios);

        // boton crear usuario
        botonCrearUsuario= findViewById(R.id.createUserButton);
        botonCrearUsuario.setOnClickListener(this);

        // boton salir
        botonSalir= findViewById(R.id.exitButton);
        botonSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.exitButton:
                Intent toStart = new Intent(this, StartMenu.class);
                finish(); // cerrar actividad actual
                startActivity(toStart);
                break;
            case R.id.createUserButton:
                Intent toCreateUser = new Intent(this, CreateUser.class);
                finish(); // cerrar actividad actual
                startActivity(toCreateUser);
                break;
            default:
                break;
        }
    }
}