package com.example.crearpartida.triggers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.crearpartida.Globals;
import com.example.crearpartida.Jugador;
import com.example.crearpartida.Partida;
import com.example.crearpartida.R;

public class DialogEliminar extends AppCompatDialogFragment {

    private Partida partida = Globals.getInstance().getGame();
    private Jugador jugador = partida.getJugadorAvisos();
    private Avis[] avisos = jugador.getLlistaAvisos();
    private DialogEliminarListener listener;
    private TableRow row;
    private char[] quinsEliminar;
    private char pos1=0, pos2=0;
    
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_eliminar, null);

        final TableLayout tl1 = view.findViewById(R.id.tlSvElim1);
        final TableLayout tl2 = view.findViewById(R.id.tlSvElim2);

        char id1 = 0, id2 = 0;
        

        quinsEliminar = new char[2 * Jugador.max_avisos];
        for(int i=0; i<quinsEliminar.length; i++)
            quinsEliminar[i] = 0;
        
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        TextView desc;

        for(int i = 0; i < jugador.getNumAvis(); i++){
            row = new TableRow(getContext());
            row.setLayoutParams(lp);

            desc = new TextView(getContext());
            desc.setText(avisos[i].getDescripcio());
            row.addView(desc);
            
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int color = ((ColorDrawable) v.getBackground()).getColor();
                    if (color == Color.GRAY || color == Color.LTGRAY) {
                        v.setBackgroundColor(Color.RED);
                        quinsEliminar[v.getId()] = 1;
                    }
                    else{
                        for(int i=0; i<tl1.getChildCount(); i++){
                            if(tl1.getChildAt(i) == v){
                                if(i % 2 == 0)
                                    v.setBackgroundColor(Color.GRAY);
                                else
                                    v.setBackgroundColor(Color.LTGRAY);
                            }
                        }
    
                        for(int i=0; i<tl2.getChildCount(); i++){
                            if(tl2.getChildAt(i) == v){
                                if(i % 2 == 0)
                                    v.setBackgroundColor(Color.GRAY);
                                else
                                    v.setBackgroundColor(Color.LTGRAY);
                            }
                        }
                        quinsEliminar[v.getId()] = 0;
                    }
                }
            });
            
            if(avisos[i].getQuan() == 1) {
                pos1 = (char) tl1.getChildCount();
                id1 = pos1;
                row.setId(id1);
                if(pos1 % 2 == 0)
                    row.setBackgroundColor(Color.GRAY);
                else
                    row.setBackgroundColor(Color.LTGRAY);
    
                tl1.addView(row, pos1);
            }
            else {
                pos2 = (char) tl2.getChildCount();
                id2 = (char) (Jugador.max_avisos + pos2 - 1);
                if(pos2 % 2 == 0)
                    row.setBackgroundColor(Color.GRAY);
                else
                    row.setBackgroundColor(Color.LTGRAY);
    
                row.setId(id2);
                tl2.addView(row, pos2);
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
                    listener.actualitzarAvisos(quinsEliminar);
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
        void actualitzarAvisos(char[] quins);
        void actualitzarAvisos();
    }
    
    
}
