package com.example.crearpartida.userlist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
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

        // imprimimos todos los nombres de la lista de usuarios
        TableLayout userList= findViewById(R.id.userList);
        int numUsuarios= 0;
        TableRow user;
        Map<String, ?> keys= prefs.getAll();
        for(Map.Entry<String, ?> entry : keys.entrySet())
        {
            user= new TableRow(this);
            userList.addView(user, numUsuarios);
            TextView textUser= new TextView(this);
            textUser.setText(entry.getValue().toString());
            textUser.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
            textUser.setPadding(0,0,50,0);
            user.addView(textUser);
            Button deleteUser= new Button(this);
            final String id= entry.getKey();
            deleteUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences prefs= getSharedPreferences("listaUsuarios", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= prefs.edit();
                    editor.remove(id);
                    editor.commit();
                    finish();
                    startActivity(getIntent());
                }
            });
            deleteUser.setText("DEL");
            user.addView(deleteUser);
            numUsuarios++;
        }
        TextView userCount= findViewById(R.id.userCount);
        userCount.setText("Número de usuarios registrados: " + numUsuarios);

        // boton crear usuario
        botonCrearUsuario= findViewById(R.id.createUserButton);
        if(numUsuarios >= 1000)
        {
            botonCrearUsuario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"La lista de usuarios esta llena.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            botonCrearUsuario.setOnClickListener(this);
        }

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