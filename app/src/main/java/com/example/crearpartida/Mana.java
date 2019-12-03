package com.example.crearpartida;

import android.graphics.Bitmap;

public class Mana {

    /* *
    array de llargada especificada pel tipus del mana
    si el tipus es 0 o 1, la seva llargada sera de 1
    si per el tipus 2,3,4
    si els del tipus 5, la seva llargada tambe sera de 1
    les id de cada mana seran:
    0-incolor
    1-blanc
    2-blau
    3-negre
    4-vermell
    5-verd
    6-universal
    * */
    private int[] manaType;         // array per especificar com es el mana segons el conveni anterior
    private int quantTotal;         // quantitat d'aquest mana total
    private int quantAvaiable;      // quantitat d'aquest mana disponible
    private boolean isIncolor;      // es incoloro?
    private boolean isUniversal;    // es universal?


    /**
     * Constructor de la classe Mana
     * Inicialitza totes les variables de la classe a 0
     * @param manaType
     */
    public Mana(int[] manaType){
        this.manaType = manaType;
        quantTotal = 0;
        quantAvaiable = 0;
        isIncolor = isManaIncolor(manaType);
        isUniversal = isManaUniversal(manaType);
    }

    /**
     * Constructor de la classe Mana
     * @param manaType: com es el mana
     * @param total: quantitat total d'aquest
     * @param avaiable: quantitat disponible d'aquest
     */
    public Mana( int[] manaType, int total, int avaiable){
        this.manaType = manaType;
        isIncolor = isManaIncolor(manaType);
        isUniversal = isManaUniversal(manaType);
        this.quantTotal = total;
        this.quantAvaiable = avaiable;
    }

    /**
     * Metode per esbrinar si el mana es incolor
     * @param manaType
     * @return true if incolor, false otherwise
     */
    private boolean isManaIncolor(int[] manaType){
        if(manaType.length == 1){
            if(manaType[0] == 0) return true;
        }
        return false;
    }

    /**
     * Metode per esbrinar si el mana es universal
     * @param manaType
     * @return true if universal, false otherwise
     */
    private boolean isManaUniversal(int[] manaType){
        if(manaType.length == 1){
            if(manaType[0] == 6) return true;
        }
        return false;
    }

    /**
     * Metode per a obtenir el nom de l'arxiu del bg que...
     * ... li correspon al mana en questio
     * @return nom de l'arxiu
     */
    public String getBackground(){
        String aux = "bg_" + getManaType().length + "_";
        for(int i = 0;i < getManaType().length; i++){
            aux = aux.concat("" + getManaType()[i]);
        }
        return aux;
    }

    /**
     * Setter de la quantitat de mana total
     * @param total
     */
    public void setTotal(int total){
        this.quantTotal = total;
    }

    /**
     * Setter de la quantitat de mana disponible
     * @param disp
     */
    public void setAvaiable(int disp){
        this.quantAvaiable = disp;
    }

    /**
     * Setter del tipus de mana
     * @param manaType
     */
    public void setManaType(int[] manaType) {
        this.manaType = manaType;
    }

    /**
     * Getter de la quantitat de mana total
     * @return quantTotal
     */
    public int getTotal(){
        return quantTotal;
    }

    /**
     * Getter de la quantitat de mana disponible
     * @return quantAvaiable
     */
    public int getAvaiable() {
        return quantAvaiable;
    }

    /**
     * Getter del tipus de mana
     * @return manaType
     */
    public int[] getManaType() {
        return manaType;
    }

    /**
     * Reseteja el mana disponible al total disponible
     */
    public void resetMana(){
        this.quantAvaiable = quantTotal;
    }

    /**
     * Augmenta el valor del mana total en una quantitat passada per parametre
     * @param cantidad
     */
    public void addTotalMana(int cantidad){
        this.quantTotal += cantidad;
        this.quantAvaiable += cantidad;
    }

    /**
     * Augmentar el Total en 1
     */
    public void addOneToTotal(){
        quantTotal += 1;
        quantAvaiable += 1;
    }

    /**
     * Augmentar el disponible en 1
     */
    public void addOneToAvaiable(){
        quantAvaiable += 1;
    }

    /**
     * Si el total es mes gran que 0, decrementar en 1
     */
    public void subOneToTotal(){
        if(getTotal() > 0){
            setTotal(getTotal() - 1);
            if(getAvaiable() > 0) setAvaiable(getAvaiable() - 1);
        }
    }

    /**
     * si el disponible es mes gran que 0, decrementar en 1
     */
    public void subOneToAvaiable(){
        if(getAvaiable() > 0) setAvaiable(getAvaiable() - 1);
    }

    /**
     * Compara si el mana sobre el que s'efectua aquest metode...
     * ... i el mana passat per parametre son iguals
     * @param mana
     * @return true if equals, false otherwise
     */
    public boolean isEqual(Mana mana){
        if(mana.getManaType().length != this.getManaType().length) return false;
        else{
            int i = 0;
            while(i < this.getManaType().length){
                if(this.getManaType()[i] != mana.getManaType()[i]) return false;
                i++;
            }
            return true;
        }
    }

    /**
     * Retorna una copia del mana sobre el qual s'esta realitzant aquest metode
     * @return copy: copia del mana
     */
    public Mana Copy(){
        Mana copy = new Mana(this.manaType, this.quantTotal, this.quantAvaiable);
        return copy;
    }

    /*
    public void gastarDisponible(int cantidad){
        quantAvaiable -= cantidad;
    }*/
}
