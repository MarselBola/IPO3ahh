package com.example.crearpartida.pool;


import com.example.crearpartida.clases.Mana;

public class ManaPool {

    private int rowTotal;           //files a mostrar a ManaTotal
    private int rowAvailable;       //files a mostrar a PoolFragment
    private int rowSpent;           //files a mostrar a mana gastant, dins de ManaAvalible;

    private int quantManaTotal;     //quantitat total de diferents tipus de mana de l'usuari
    private int quantManaSpent;     //quantitat de mana que s'esta gastant

    private Mana[] manaArray;       //llista de tot el mana posible
    private Mana[] manaAvailable;   //llista del mana disponible per l'usuari
    private Mana[] manaSpent;       //llista del mana que s'esta gastant
    private Mana[] manaCheckpoint;  //ultim checkpoint de mana realitzat


    /**
     * Constructor de la classe ManaPool
     * Inicialitza totes les variables de classe a 0
     * Crea la array de manas
     */
    public ManaPool(){
        rowTotal = 0;
        rowAvailable = 0;
        rowSpent = 0;

        quantManaTotal = 0;
        quantManaSpent = 0;

        manaArray = new Mana[32];
        manaAvailable = new Mana[32];
        manaSpent = new Mana[32];
        manaCheckpoint = new Mana[32];
    }

    /**
     * Getter de les files totals del mana disponible
     * @return rowAvaiable
     */
    public int getRowAvailable() {
        return rowAvailable;
    }

    /**
     * Setter de les files totals del mana disponible
     * @param num
     */
    public void setRowAvaiable(int num){ this.rowAvailable = num; }

    /**
     * Getter de les files totals del mana a gastar
     * @return rowSpent
     */
    public int getRowSpent() {
        return rowSpent;
    }

    /**
     * Setter de les files de mana gastantse
     * @param num
     */
    public void setRowSpent(int num) { this.rowSpent = num; }

    /**
     * Getter de les files totals del mana total
     * @return rowTotal
     */
    public int getRowTotal()
    {
        return rowTotal;
    }

    /**
     * Setter de les files totals del mana total
     * @param num
     */
    public void setRowTotal(int num) { this.rowTotal = num; }

    /**
     * Getter de la quantitat de mana total del jugador
     * @return quantManaTotal
     */
    public int getQuantManaTotal()
    {
        return quantManaTotal;
    }

    /**
     * Setter de la quantitat de mana total del jugador
     * @param num
     */
    public void setQuantManaTotal(int num) { this.quantManaTotal = num; }

    /**
     * Getter de la quantitat de mana que esta gastant el jugador
     * @return
     */
    public int getQuantManaSpent() { return this.quantManaSpent; }

    /**
     * Setter de la quantitat de mana que esta gastant el jugador
     * @param quantManaSpent
     */
    public void setQuantManaSpent(int quantManaSpent) { this.quantManaSpent = quantManaSpent; }

    /**
     * Getter de la array de mana total del jugador
     * @return manaArray
     */
    public Mana[] getManaArray()
    {
        return manaArray;
    }

    /**
     * Setter de la array de mana total del jugador
     * @param mana
     */
    public void setManaArray(Mana[] mana) { this.manaArray = mana; }

    /**
     * Getter de la array del mana disponible del jugador
     * @return manaAvailable
     */
    public Mana[] getManaAvailable() { return manaAvailable; }

    /**
     * Setter de la array del mana disponible del jugador
     * @param mana
     */
    public void setManaAvailable(Mana[] mana) { this.manaAvailable = mana; }

    /**
     * Getter de la array de l'ultim CheckPoint del jugador
     * @return manaCheckpoint
     */
    public Mana[] getManaCheckpoint() { return manaCheckpoint; }

    /**
     * Setter de la array de l'ultim CheckPoint del jugador
     * @param mana
     */
    public void setManaCheckpoint(Mana[] mana) { this.manaCheckpoint = mana; }

    /**
     * Getter de la array de mana que esta gastant el jugador
     * @return manaSpent
     */
    public Mana[] getManaSpent()
    {
        return manaSpent;
    }

    /**
     * Setter de la array de mana que esta gastant el jugador
     * @param mana
     */
    public void setManaSpent(Mana[] mana) { this.manaSpent = mana; }

    /**
     * Retorna la posicio on es troba el mana passat per parametre
     * @param mana
     * @return pos in the manaArray
     */
    public int getManaPosition(Mana mana, Mana[] manaArray, int limit)
    {
        for(int pos = 0; pos < limit; pos++)
        {
            if(manaArray[pos].isEqual(mana)) return pos;
        }
        return -1;
    }

    /**
     * Afegeix un manaType a la manaArray del jugador.
     * si ja es troba dins l'array, augmenta la seva...
     * ...quantitat de mana d'aquest tipus
     * @param mana
     */
    public void addManaAtTotal(Mana mana)
    {
        int pos = getManaPosition(mana, getManaArray(), getQuantManaTotal());
        if(pos == -1)
        {
            //si pos == -1 vol dir que no ha trobat el mana dins l'array
            manaArray[quantManaTotal] = mana;
            manaAvailable[quantManaTotal] = mana.Copy();
            manaCheckpoint[quantManaTotal] = mana.Copy();
            quantManaTotal++;
            if(quantManaTotal % 4 == 1) rowTotal++;
            if(quantManaTotal % 2 == 1) rowAvailable++;
        }
        else{
            manaArray[pos].addTotalMana(mana.getTotal()); //augmentem el nombre de mana del tipus
            manaAvailable[pos].addTotalMana(mana.getTotal());
            manaCheckpoint[pos].addTotalMana(mana.getTotal());
        }
    }

    /**
     * Afegim un manaType a la manaSpent del jugador
     * si ja es troba dins l'array, augmentem la seva quantitat
     * @param mana
     */
    public void addManaAtSpent(Mana mana)
    {
        int pos = getManaPosition(mana, getManaSpent(), getQuantManaSpent());
        if(pos == -1)
        {
            manaSpent[quantManaSpent] = mana;
            manaSpent[quantManaSpent].setTotal(1);
            quantManaSpent++;
            if (quantManaSpent % 2 == 1) rowSpent++;
        }
        else manaSpent[pos].addTotalMana(mana.getTotal());
    }

    /**
     * Busca el mana passat per referencia dins la manaArray i l'elimina
     * @param mana
     */
    public void removeManaFromTotal(Mana mana)
    {
        int pos = getManaPosition(mana, getManaArray(), getQuantManaTotal());
        if(pos != -1){
            for (int i = pos; i < quantManaTotal-1; i++) //desplaça tots els elements de la array una pos endevant
                manaArray[i] = manaArray[i + 1].Copy();
            manaArray[quantManaTotal-1] = null;
            quantManaTotal--;
        }
        //else: error, el mana no esta dins l'array;
    }

    public Mana[] copyCheckPoint(){
        Mana[] copy = new Mana[32];
        for(int i = 0; i<quantManaTotal;i++){
            copy[i] = manaCheckpoint[i].Copy();
        }
        return copy;
    }
    public Mana[] copyManaTotal(){
        Mana[] copy = new Mana[32];
        for(int i = 0; i<quantManaTotal;i++){
            copy[i] = manaArray[i].Copy();
        }
        return copy;
    }
    public Mana[] copyManaAvailable(){
        Mana[] copy = new Mana[32];
        for(int i = 0; i<quantManaTotal;i++){
            copy[i] = manaAvailable[i].Copy();
        }
        return copy;
    }

}
