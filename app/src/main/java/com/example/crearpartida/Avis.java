package com.example.crearpartida;

public class Avis {
    private String nom, descripcio;
    private String quan;
    
    public Avis (String nom, String descripcio, int quan){
        this.nom = nom;
        this.descripcio = descripcio;
        
        // fer switch per crear quan
        switch (quan){
            case 1:
                this.quan = "Principi turno";
                break;
            case 2:
                this.quan = "Final turno";
                break;
        }
    }
    
    public Avis getAvis(){
        return this;
    }
    
}
