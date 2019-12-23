package com.example.crearpartida.triggers;

public class Avis {
    private String descripcio;
    private int quan, id;
    
    public Avis (String descripcio, int quan, int id){
        this.descripcio = descripcio;
        this.quan = quan;
        this.id = id;
    }

    public String getDescripcio() {
        return descripcio;
    }
    
    public int getQuan() {
        return quan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }
}
