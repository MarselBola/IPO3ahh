package com.example.crearpartida.triggers;

public class Avis {
    private String nom, descripcio;
    private int quan;
    
    public Avis (String nom, String descripcio, int quan){
        this.nom = nom;
        this.descripcio = descripcio;
        this.quan = quan;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getDescripcio() {
        return descripcio;
    }
    
    public int getQuan() {
        return quan;
    }
}
