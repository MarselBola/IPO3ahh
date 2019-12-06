package com.example.crearpartida.triggers;

public class QuinAvisEliminar {
    private char[] quinsEliminar;
    private int max;
    private int numAvisos;
    
    public QuinAvisEliminar(int max){
        numAvisos = 0;
        this.max = max;
        quinsEliminar = new char[max];
    }
    
    public char[] getQuinsEliminar() {
        return quinsEliminar;
    }
    
    public int getMax() {
        return max;
    }
    
    public int getNumAvisos() {
        return numAvisos;
    }
    
    public void setNumAvisos(int numAvisos) {
        this.numAvisos = numAvisos;
    }
}
