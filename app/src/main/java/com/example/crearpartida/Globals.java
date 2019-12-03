package com.example.crearpartida;

public class Globals {
    private static final Globals ourInstance = new Globals();

    public static Globals getInstance() {
        return ourInstance;
    }
    private Partida game;
    private Jugador  player = new Jugador(40, "Bruh");
    public Jugador getPlayer() {return this.player;}
    private Globals() {
    }
    public void setGame(Partida p){
        this.game = p;
    }
    public Partida getGame(){
        return this.game;
    }
}
