package com.example.crearpartida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class UserList extends AppCompatActivity implements View.OnClickListener {
    Button botonSalir;

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
        LinearLayout linearLayout= findViewById(R.id.userList);
        int numUsuarios= 0;
        Map<String, ?> keys= prefs.getAll();
        for(Map.Entry<String, ?> entry : keys.entrySet())
        {
            TextView textView= new TextView(this);
            textView.setId(Integer.parseInt(entry.getKey()));
            textView.setText(entry.getValue().toString());
            linearLayout.addView(textView);
            numUsuarios++;
        }
        System.out.println("numero usuarios: " + numUsuarios);

        // boton salir
        botonSalir= findViewById(R.id.exitButton);
        botonSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.exitButton)
        {
            Intent toStart = new Intent(this, StartMenu.class);
            finish(); // cerrar actividad actual
            startActivity(toStart);
        }
    }
}