package com.example.crearpartida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddMana extends AppCompatActivity {
    Mana manaToAdd;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int[] manaType = new int[1];
    int Cantidad = 1;
    EditText cantidadMana;
    int seleccionados;
    Partida partida;
    String nombre_jugador;
    Jugador jugador;
    ManaPool manaJugador;
    Globals g = Globals.getInstance();
    CheckBox check;
    Intent back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_mana);
        back = new Intent(this , ManaTotal.class);
        radioGroup = findViewById(R.id.radioGroup);

        Button buttonAñadir = findViewById(R.id.button_añadir);
        buttonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadMana = findViewById(R.id.editText);
                if(cantidadMana.getText().toString().isEmpty()) {
                    Toast.makeText(AddMana.this, "Indica la cantidad de mana", Toast.LENGTH_SHORT).show();
                }
                else{
                    seleccionados = 0;
                    check = findViewById(R.id.check_blanco);
                    if(check.isChecked()) { seleccionados++; }
                    check = findViewById(R.id.check_azul);
                    if(check.isChecked()) { seleccionados++; }
                    check = findViewById(R.id.check_negro);
                    if(check.isChecked()) { seleccionados++; }
                    check = findViewById(R.id.check_rojo);
                    if(check.isChecked()) { seleccionados++; }
                    check = findViewById(R.id.check_verde);
                    if(check.isChecked()) { seleccionados++; }
                    if((seleccionados != Cantidad) && (Cantidad != 0)){
                        Toast.makeText(AddMana.this, "La seleccion de mana es incorrecta", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(Cantidad == 0) {
                            manaToAdd = new Mana(manaType);
                        }
                        else{
                            manaType = new int[Cantidad];
                            seleccionados=0;
                            check = findViewById(R.id.check_blanco);
                            if(check.isChecked()) {
                                manaType[seleccionados] = 1;
                                seleccionados++;
                            }
                            check = findViewById(R.id.check_azul);
                            if(check.isChecked()) {
                                manaType[seleccionados] = 2;
                                seleccionados++;
                            }
                            check = findViewById(R.id.check_negro);
                            if(check.isChecked()) {
                                manaType[seleccionados] = 3;
                                seleccionados++;
                            }
                            check = findViewById(R.id.check_rojo);
                            if(check.isChecked()) {
                                manaType[seleccionados] = 4;
                                seleccionados++;
                            }
                            check = findViewById(R.id.check_verde);
                            if(check.isChecked()) {
                                manaType[seleccionados] = 5;
                                seleccionados++;
                            }
                            manaToAdd = new Mana(manaType);
                        }
                        manaToAdd.addTotalMana(Integer.parseInt(cantidadMana.getText().toString()));
                        g.getPlayer().getPlayerMana().addManaAtArray(manaToAdd);

                        startActivity(back);

                        finish();
                    }

                }

            }
        });



    }
    public void exit(View v){
        Intent intent = new Intent(this, ManaTotal.class);
        startActivity(intent);
        this.finish();
    }
    public void setCantidad(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        if(radioButton.getText().equals("Monocolor")) {
            Cantidad = 1;
        }
        if(radioButton.getText().equals("Doble")) {
            Cantidad = 2;
        }
        if(radioButton.getText().equals("Triple")) {
            Cantidad = 3;
        }
        if(radioButton.getText().equals("Cuadruple")) {
            Cantidad = 4;
        }
        if(radioButton.getText().equals("Incoloro")||radioButton.getText().equals("Cualquier color")) {
            Cantidad = 0;
        }
        if(Cantidad!=0) {
            manaType = new int[Cantidad];
        }
        else{
            if(radioButton.getText().equals("Incoloro")){

                manaType[0] = 0;
            }
            else
            {

                manaType[0] = 6;
            }
        }
    }
}
