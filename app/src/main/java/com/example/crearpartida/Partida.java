package com.example.crearpartida;

public class Partida {
    private int numJug;
    private String format;
    private Jugador[] Jugadors;
    private int torn = 0;

    public Partida ()
    {

    }

    public Partida (int numJug, String format, int vida)
    {
        this.format = format;
        this.numJug = numJug;
        Jugadors = new Jugador[numJug];
        for(int i=0; i<numJug;i++){
            Jugadors[i].setVida(vida);
            Jugadors[i].setNom("Jugador "+(i+1));
        }
        torn=0;
    }

    public Partida crearPartida(int numJug, String format, int vida)
    {

        Partida new_game = new Partida(numJug, format, vida);
        return new_game;
    }
    public void setNumJug(int numJug){
        this.numJug = numJug;
    }
    public void setFormat(String f){
        format = f;
    }
    public void setDefaultNamesWHP(int vida){
        Jugadors = new Jugador[numJug];
        for(int i=0; i<numJug;i++){
            Jugadors[i]=new Jugador();
            Jugadors[i].setVida(vida);
            Jugadors[i].setNom("Jugador "+(i+1));
        }
    }
    public Jugador getJugadorConNombre(String nom){
        return Jugadors[buscarPosJugador(nom)];
    }
    public int buscarPosJugador(String nom){
        boolean found = false;
        int i = 0;
        while(i<numJug && !found){
            if(nom.equalsIgnoreCase(Jugadors[i].getNom())){
                found = true;
            }
            else i++;
        }
        return i;
    }
}
