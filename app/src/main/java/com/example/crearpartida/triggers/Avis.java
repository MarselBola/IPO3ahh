package com.example.crearpartida.triggers;

public class Avis {
    private String descripcio;
    private int quan;
    
    public Avis (String descripcio, int quan){
        this.descripcio = descripcio;
        this.quan = quan;
    }

    public String getDescripcio() {
        return descripcio;
    }
    
    public int getQuan() {
        return quan;
    }
}
