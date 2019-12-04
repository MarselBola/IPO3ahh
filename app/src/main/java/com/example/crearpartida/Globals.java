package com.example.crearpartida;

public class Globals {
    private static final Globals ourInstance = new Globals();
    
    public static Globals getInstance() {
        return ourInstance;
    }
    
    private Partida game;
    private Jugador  player = new Jugador(40, "Bruh");
    private Jugador jugadorAvisos;      // jugador actual per mostrar avisos
    
    private Globals() {
    }
    
    public void setGame(Partida p){
        this.game = p;
    }
    
    public Partida getGame(){
        return this.game;
    }
    public Jugador getPlayer() {return this.player;}
    
    public void setJugadorAvisos(Jugador jug){
        jugadorAvisos = jug;
    }
    
    public Jugador getJugadorAvisos(){
        return this.jugadorAvisos;
    }
}
