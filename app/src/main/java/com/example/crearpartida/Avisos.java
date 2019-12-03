package com.example.crearpartida;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Avisos extends AppCompatActivity implements View.OnClickListener, DialogCrear.DialogCrearListener {
    
    TableLayout tlsv1, tlsv2;
    Button back, crear, elim;
    int id1=0, id2=0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avisos);
        
        tlsv1 = findViewById(R.id.tlSv1);
        tlsv2 = findViewById(R.id.tlSv2);
        
        back = findViewById(R.id.bAvisBack);
        back.setOnClickListener(this);
        
        crear = findViewById(R.id.bAvisCrear);
        crear.setOnClickListener(this);
        
        elim = findViewById(R.id.bAvisEliminar);
        elim.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        
        //Intent back = new Intent(this, PartidaActivity.class);
        
        switch (v.getId()){
            case R.id.bAvisBack:
                this.finish();
                break;
            case R.id.bAvisCrear:
                DialogCrear dialog = new DialogCrear();
                dialog.show(getSupportFragmentManager(), "");
                break;
            case R.id.bAvisEliminar:
                TableRow row;
                TableRow.LayoutParams lp;
                TextView count;
                int c = tlsv1.getChildCount();
                if(c > 0) {
                    row = new TableRow(this);
                    lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    row.setLayoutParams(lp);
                    count = new TextView(this);
                    count.setText(c);
                    row.addView(count);
                    tlsv1.addView(row);
                }
                
                int a = tlsv2.getChildCount();
                if(a > 0){
                    row = new TableRow(this);
                    lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    row.setLayoutParams(lp);
                    count = new TextView(this);
                    count.setText(a);
                    row.addView(count);
                    tlsv2.addView(row);
                }
                break;
        }
    }
    
    
    @Override
    public void parametresDialog(String nombre, String desc, int quan, boolean toast) {
        
        if(toast)
            Toast.makeText(getApplicationContext(), "Parametros introducidos incompletos\nNo se han guardado los datos",Toast.LENGTH_LONG).show();
        else{
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            
            // genera tot el q s'ha de posar
            TextView espai = new TextView(this);
            espai.setText(" - ");
            TextView nom = new TextView(this);
            nom.setText(nombre);
            TextView descrip = new TextView(this);
            descrip.setText(desc);
            
            row.addView(nom);
            row.addView(espai);
            row.addView(descrip);
            
            //Global.setAvis(new Avis(nombre, desc, quan));
            // nse si cal guardar l'avis
            
            // posar-ho al layout
            if(quan == 1) {
                row.setId(1+id1);
                if(id1 % 2 == 0)
                    row.setBackgroundColor(Color.GRAY);
                else
                    row.setBackgroundColor(Color.LTGRAY);
                tlsv1.addView(row, id1);
                id1++;
            }
            else {
                row.setId(2+id2);
                if(id2 % 2 == 0)
                    row.setBackgroundColor(Color.GRAY);
                else
                    row.setBackgroundColor(Color.LTGRAY);
                tlsv2.addView(row, id2);
                id2++;
            }
        }
    }
}
