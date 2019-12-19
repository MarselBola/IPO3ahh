package com.example.crearpartida.triggers;

import android.content.Context;

public class ButtonEdit extends androidx.appcompat.widget.AppCompatButton {

    private int idAvis;

    public ButtonEdit(Context context) {
        super(context);
    }

    public int getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }
}
