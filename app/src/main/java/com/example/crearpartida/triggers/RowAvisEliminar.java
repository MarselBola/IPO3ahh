package com.example.crearpartida.triggers;

import android.content.Context;
import android.widget.TableRow;

public class RowAvisEliminar extends TableRow {

    private int posTaulaAvisos;
    private boolean eliminar=false;

    public RowAvisEliminar(Context context, int pos, boolean elim){
        super(context);
        posTaulaAvisos = pos;
        eliminar = elim;
    }

    public int getPosTaulaAvisos() {
        return posTaulaAvisos;
    }

    public void setPosTaulaAvisos(int posTaulaAvisos) {
        this.posTaulaAvisos = posTaulaAvisos;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }
}
