package com.example.crearpartida;

import com.example.crearpartida.triggers.Avis;

public class Jugador {
    private int vida;
    private String nom;
    private ManaPool playerMana = new ManaPool();
    private Avis[] llistaAvisos = new Avis[20];
    private int nAvis = 0;
    
    public Jugador(){
    
    }
    
    public Jugador(int vida, String nom) {
        this.vida = vida;
        this.nom = nom;
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
    public Avis[] getLlistaAvisos(){ return llistaAvisos;}
    public int getNumAvis() { return nAvis; }
    
    public void decreaseVida(){ vida--; }
    public void incrementVida(){ vida++; }
}
