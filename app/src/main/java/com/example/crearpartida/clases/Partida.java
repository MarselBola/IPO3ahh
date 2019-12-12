package com.example.crearpartida.clases;

public class Partida {
    private int numJug;
    private String format;
    private Jugador[] Jugadors;
    private int torn = 0;
    private Jugador jugadorActual;
    private Jugador jugadorAvisos;      // jugador a mostrar los triggers

    public Partida ()
    {

    }

    public Partida (int numJug, String format, int vida)
    {
        this.format = format;
        this.numJug = numJug;
        Jugadors = new Jugador[numJug];
        for(int i=0; i<numJug;i++){
            Jugadors[i].setNom("Jugador " + (i+1));
        }
        jugadorActual = Jugadors[0];
        torn=0;
    }

    public Partida crearPartida(int numJug, String format, int vida){
        return new Partida(numJug, format, vida);
    }

    public Jugador[] getJugadors(){ return Jugadors; }
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
            Jugadors[i].setNom("Jugador " + (i+1));
        }
        jugadorActual = Jugadors[0];
    }

    public int getNumJug(){ return numJug; }
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
    public int getTorn(){
      return torn;
    }
    public  Jugador[] getLlistaJugadors() { return this.Jugadors; }

    public Jugador getJugadorActual(){ return jugadorActual; }
    
    public void setJugadorActual(Jugador jugAct) {jugadorActual = jugAct; }

    public void setJugadorAvisos(Jugador jug){
        jugadorAvisos = jug;
    }

    public Jugador getJugadorAvisos(){
        return this.jugadorAvisos;
    }

    public void nextTurn(){
        torn += 1;
        torn = torn % numJug;
    }
}
