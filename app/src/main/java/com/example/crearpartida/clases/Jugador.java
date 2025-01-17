package com.example.crearpartida.clases;


import com.example.crearpartida.triggers.Avis;

import java.util.ArrayList;

import com.example.crearpartida.pool.ManaPool;


public class Jugador {
    private int vida;
    private String nom;
    private ManaPool playerMana = new ManaPool();

    static final private int max_avisos = 50;
    private ArrayList<Avis> llistaAvisos = new ArrayList<>(max_avisos);
    private int numIdAvis = 1;

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
    //public void setNumAvis(int num) { this.nAvis = num; }

    public String getNom(){
        return nom;
    }
    public ManaPool getPlayerMana(){
        return playerMana;
    }
    public ArrayList<Avis> getLlistaAvisos(){ return llistaAvisos;}
    public int getMaxAvisos() { return max_avisos; }
    public int getNumIdAvis(){ return numIdAvis; }
    public void augmentaNumIdAvis() { this.numIdAvis++; }
    public void decrementaNumIdAvis() { this.numIdAvis--; }

    public void decreaseVida(){ vida--; }
    public void incrementVida(){ vida++; }

}