package com.example.crearpartida.triggers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.crearpartida.*;

public class DialogEliminar extends AppCompatDialogFragment {
    
    Jugador[] jugadors = Globals.getInstance().getGame().getLlistaJugadors();
    private DialogEliminarListener listener;
    
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_eliminar, null);
    
        TableLayout tl1 = view.findViewById(R.id.tlSvElim1);
        TableLayout tl2 = view.findViewById(R.id.tlSvElim2);
        
        Button elim;
        
        
        // posar coses al view
        
    
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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
