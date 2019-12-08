package com.example.crearpartida.triggers;

import android.content.Context;
import android.widget.TableRow;

public class RowAvisEliminar extends TableRow {

    private boolean eliminar=false;
    private Avis avis;

    public RowAvisEliminar(Context context, boolean elim, Avis avis){
        super(context);
        eliminar = elim;
        this.avis = avis;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public Avis getAvis() {
        return avis;
    }
}
