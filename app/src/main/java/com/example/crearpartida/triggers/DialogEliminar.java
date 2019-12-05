package com.example.crearpartida.triggers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.crearpartida.*;

public class DialogEliminar extends AppCompatDialogFragment {

    private Partida partida = Globals.getInstance().getGame();
    private Jugador jugador = partida.getJugadorAvisos();
    private Avis[] avisos = jugador.getLlistaAvisos();
    private DialogEliminarListener listener;
    
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_eliminar, null);

        TableLayout tl1 = view.findViewById(R.id.tlSvElim1);
        TableLayout tl2 = view.findViewById(R.id.tlSvElim2);

        int id1 = 0, id2 = 0;

        TableRow row;
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        TextView desc;
        // CheckBox checkBox;

        for(int i = 0; i < jugador.getNumAvis(); i++){
            row = new TableRow(getContext());
            row.setLayoutParams(lp);

            desc = new TextView(getContext());
            desc.setText(avisos[i].getDescripcio());
            row.addView(desc);

            //TODO mirar com fer per seleccionar quins eliminar

            if(avisos[i].getQuan() == 1) {
                id1 = tl1.getChildCount();
                row.setId(id1);
                if(id1 % 2 == 0)
                    row.setBackgroundColor(Color.GRAY);
                else
                    row.setBackgroundColor(Color.LTGRAY);
                tl1.addView(row, id1);
            }
            else {
                id2 = tl2.getChildCount();
                row.setId(id2);
                if(id2 % 2 == 0)
                    row.setBackgroundColor(Color.GRAY);
                else
                    row.setBackgroundColor(Color.LTGRAY);
                tl2.addView(row, id2);
            }

        }
        
    
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            
            }
            })
            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //TODO comprovar quins eliminar i eliminar
                    listener.actualitzarAvisos();
                }
            });
    
        return builder.create();
    }
    
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DialogEliminarListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "falta implementar DialogEliminarListener");
        }
    }
    
    public interface DialogEliminarListener{
        void actualitzarAvisos();
    }
    
    
}
