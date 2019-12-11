package com.example.crearpartida.triggers;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crearpartida.Globals;
import com.example.crearpartida.Jugador;
import com.example.crearpartida.Partida;
import com.example.crearpartida.R;

import java.util.ArrayList;

public class Avisos extends AppCompatActivity implements View.OnClickListener, DialogCrear.DialogCrearListener, DialogEliminar.DialogEliminarListener {
    
    TableLayout tlsv1, tlsv2;
    Button back, crear, elim;
    TextView tvAvis;
    int id1=0, id2=0;
    Partida partida = Globals.getInstance().getGame();
    Jugador jugadorAvisos = partida.getJugadorAvisos();
    ArrayList<Avis> avisos =  jugadorAvisos.getLlistaAvisos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avisos);
        
        String titol = "Avisos: " + getIntent().getStringExtra("player");
        tvAvis = findViewById(R.id.textViewAvis);
        tvAvis.setText(titol);
        
        tlsv1 = findViewById(R.id.tlSv1);
        tlsv2 = findViewById(R.id.tlSv2);
        
        back = findViewById(R.id.bAvisBack);
        back.setOnClickListener(this);
        
        crear = findViewById(R.id.bAvisCrear);
        crear.setOnClickListener(this);
        
        elim = findViewById(R.id.bAvisEliminar);
        elim.setOnClickListener(this);
        
        actualitzarAvisos();
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bAvisBack:
                if(partida.getNumJug() == 1){
                    Uri uri = Uri.parse(""+1);
                    Intent canvi = new Intent(null, uri);
                    setResult(RESULT_OK, canvi);
                }
                this.finish();
                break;
            case R.id.bAvisCrear:
                DialogCrear dialogCrear = new DialogCrear();
                dialogCrear.show(getSupportFragmentManager(), "");
                break;
            case R.id.bAvisEliminar:
                DialogEliminar dialogEliminar = new DialogEliminar();
                dialogEliminar.show(getSupportFragmentManager(), "");
                break;
        }
    }
    
    
    @Override
    public void parametresDialog(String desc, int quan, boolean toast) {
        if(toast)
            Toast.makeText(getApplicationContext(), "Parametros introducidos incompletos\nNo se han guardado los datos",Toast.LENGTH_LONG).show();
        else{
            avisos.add(new Avis(desc, quan));
            agregarAviso(desc, quan);
        }
    }
    
    
    @Override
    public void actualitzarAvisos() {
        tlsv1.removeAllViews();
        tlsv2.removeAllViews();

        for(int i=0; i<avisos.size(); i++){
            agregarAviso(avisos.get(i).getDescripcio(), avisos.get(i).getQuan());
        }
    }
    
    private void agregarAviso(String desc, int quan){
        TableRow row = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
    
        // genera tot el q s'ha de posar
        TextView descrip = new TextView(this);
        descrip.setText(desc);
        row.addView(descrip);
    
        // posar-ho al layout
        if(quan == 1) {
            id1 = tlsv1.getChildCount();
            row.setId(id1);
            if(id1 % 2 == 0)
                row.setBackgroundColor(Color.GRAY);
            else
                row.setBackgroundColor(Color.LTGRAY);
                
            tlsv1.addView(row, id1);
            id1++;
        }
        else {
            id2 = tlsv2.getChildCount();
            row.setId(id2);
            if(id2 % 2 == 0)
                row.setBackgroundColor(Color.GRAY);
            else
                row.setBackgroundColor(Color.LTGRAY);
            tlsv2.addView(row, id2);
            id2++;
        }
    }
}
