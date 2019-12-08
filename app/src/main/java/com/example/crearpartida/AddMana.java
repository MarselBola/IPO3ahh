package com.example.crearpartida;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.crearpartida.pool.ManaPool;

public class AddMana extends Fragment {
    Mana manaToAdd;
    int[] manaType = new int[1];
    int Cantidad = 1;
    EditText cantidadMana;

    int seleccionados;
    String bg_string, bg_string2;
    Partida partida;
    String nombre_jugador;
    Jugador jugador;
    ManaPool manaJugador;
    Globals g = Globals.getInstance();
    CheckBox check;
    View root;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.add_mana, container, false);

        root.findViewById(R.id.previewMana).setBackgroundResource(R.drawable.bg_1_0);
        check = root.findViewById(R.id.check_blanco);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPreviewMana();
            }
        });
        check = root.findViewById(R.id.check_azul);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPreviewMana();
            }
        });
        check = root.findViewById(R.id.check_negro);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPreviewMana();
            }
        });
        check = root.findViewById(R.id.check_rojo);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPreviewMana();
            }
        });
        check = root.findViewById(R.id.check_verde);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPreviewMana();
            }
        });
        Button buttonAñadir = root.findViewById(R.id.button_añadir);
        buttonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadMana = root.findViewById(R.id.editText);
                if(cantidadMana.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Indica la cantidad de mana", Toast.LENGTH_SHORT).show();
                }
                else{


                    if(Cantidad == 0) {
                        manaToAdd = new Mana(manaType);
                    }
                    else{
                        manaType = new int[Cantidad];
                        seleccionados=0;
                        check = root.findViewById(R.id.check_blanco);
                        if(check.isChecked()) {
                            manaType[seleccionados] = 1;
                            seleccionados++;
                        }
                        check = root.findViewById(R.id.check_azul);
                        if(check.isChecked()) {
                            manaType[seleccionados] = 2;
                            seleccionados++;
                        }
                        check = root.findViewById(R.id.check_negro);
                        if(check.isChecked()) {
                            manaType[seleccionados] = 3;
                            seleccionados++;
                        }
                        check = root.findViewById(R.id.check_rojo);
                        if(check.isChecked()) {
                            manaType[seleccionados] = 4;
                            seleccionados++;
                        }
                        check = root.findViewById(R.id.check_verde);
                        if(check.isChecked()) {
                            manaType[seleccionados] = 5;
                            seleccionados++;
                        }
                        manaToAdd = new Mana(manaType);
                    }
                    manaToAdd.addTotalMana(Integer.parseInt(cantidadMana.getText().toString()));
                    g.getPlayer().getPlayerMana().addManaAtArray(manaToAdd);

                    Fragment manatotal = new ManaTotal();
                    FragmentManager fm = getParentFragment().getChildFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.manafragment, manatotal);
                    fragmentTransaction.commit();
                }

            }
        });

        ImageButton buttonBack = root.findViewById(R.id.imageButton);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment manatotal = new ManaTotal();
                FragmentManager fm = getParentFragment().getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.manafragment, manatotal);
                fragmentTransaction.commit();
            }});


        return root;
    }

    public void setPreviewMana(){
        int id;
        bg_string2 = "";
        bg_string = "bg_";
        boolean checked;
        seleccionados = 0;
        check = root.findViewById(R.id.check_blanco);
        checked = check.isChecked();
        if(checked) {
            seleccionados++;
            bg_string2 = bg_string2 + "1";
        }
        check = root.findViewById(R.id.check_azul);
        checked = check.isChecked();
        if(checked) {
            seleccionados++;
            bg_string2 = bg_string2 + "2";
        }
        check = root.findViewById(R.id.check_negro);
        checked = check.isChecked();
        if(checked) {
            seleccionados++;
            bg_string2 = bg_string2 + "3";
        }
        check = root.findViewById(R.id.check_rojo);
        checked = check.isChecked();
        if(checked) {
            seleccionados++;
            bg_string2 = bg_string2 + "4";
        }
        check = root.findViewById(R.id.check_verde);
        checked = check.isChecked();
        if(checked) {
            seleccionados++;
            bg_string2 = bg_string2 + "5";
        }
        bg_string = bg_string + seleccionados + "_" + bg_string2;
        Cantidad = seleccionados;
        if(seleccionados == 5){
            bg_string = "bg_1_6";
            manaType[0] = 6;
            Cantidad = 0;
        }
        if(seleccionados == 0){
            bg_string = "bg_1_0";
            manaType[0] = 0;
            Cantidad = 0;
        }
        id = getResources().getIdentifier(bg_string, "drawable", getActivity().getPackageName());
        root.findViewById(R.id.previewMana).setBackgroundResource(id);


    }
}
