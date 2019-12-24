package com.example.crearpartida.clases;

public class Globals {
    private static final Globals ourInstance = new Globals();

    public static Globals getInstance()
    {
        return ourInstance;
    }

    private Partida game;

    private Jugador  player;

    public void setPlayer(Jugador player){
        this.player = player;
    }

    public Jugador getPlayer()
    {
        return this.player;
    }
    


    private Globals()
    {

    }

    public void setGame(Partida p)
    {
        this.game = p;
    }

    public Partida getGame()
    {
        return this.game;
    }

}
