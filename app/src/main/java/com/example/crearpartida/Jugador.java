package com.example.crearpartida;

import com.example.crearpartida.pool.ManaPool;

public class Jugador {
    private int vida;
    private String nom;
    private ManaPool playerMana = new ManaPool();

    public Jugador(){

    }
    public Jugador(int vida, String nom) {
        this.vida = vida;
        this.nom = nom;
    }
    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
    public ManaPool getPlayerMana(){
        return playerMana;
    }
    public void decreaseVida(){ vida--; }
    public void incrementVida(){ vida++; }


}
