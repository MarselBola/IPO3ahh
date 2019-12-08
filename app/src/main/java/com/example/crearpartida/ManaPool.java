package com.example.crearpartida;


public class ManaPool {

    private int rowTotal;           //files a mostrar a ManaTotal
    private int rowAvailable;       //files a mostrar a PoolFragment
    private int rowSpent;           //files a mostrar a mana gastant, dins de ManaAvalible;

    private int quantManaTotal;     //quantitat total de diferents tipus de mana de l'usuari
    private int quantManaSpent;     //quantitat de mana que s'esta gastant

    private Mana[] manaArray;       //llista de tot el mana posible
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/pool/ManaPool.java
    private Mana[] manaAvailable;   //llista del mana disponible per l'usuari
    private Mana[] manaSpent;       //llista del mana que s'esta gastant
    private Mana[] manaCheckpoint;  //ultim checkpoint de mana realitzat
=======
    private Mana[] manaSpent;       //utilitza el total del mana com a comptador
    private Mana[] manaCheckpoint;
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/ManaPool.java


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
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/pool/ManaPool.java
        manaCheckpoint = new Mana[32];
=======
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/ManaPool.java
    }

    /**
     * Getter de les files totals del mana disponible
     * @return rowAvaiable
     */
<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/pool/ManaPool.java
    public int getRowAvailable() {
        return rowAvailable;
=======
    public ManaPool(Mana[] manaArray, int quant){
        this.manaArray = manaArray;
        quantManaTotal = quant;
        quantManaSpent = 0;
        if(quant > 0){
            rowTotal = 1 + quant / 4;
            rowAvaiable = 1 + quant / 2;
        }
        else {
            rowTotal = 0;
            rowAvaiable = 0;
        }
        manaSpent = new Mana[32];
        rowSpent = 0;
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/ManaPool.java
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

<<<<<<< HEAD:app/src/main/java/com/example/crearpartida/pool/ManaPool.java
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

=======
>>>>>>> parent of 9fbd366... Merge branch 'master' of https://github.com/MarselBola/IPO3ahh:app/src/main/java/com/example/crearpartida/ManaPool.java
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
            manaAvailable[quantManaTotal] = mana;
            quantManaTotal++;
            if(quantManaTotal % 4 == 1) rowTotal++;
            if(quantManaTotal % 2 == 1) rowAvailable++;
        }
        else{
            manaArray[pos].addTotalMana(mana.getTotal()); //augmentem el nombre de mana del tipus
            manaAvailable[pos].addTotalMana(mana.getTotal());
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
            for (int i = pos; i < 31; i++) //desplaça tots els elements de la array una pos endevant
                manaArray[i] = manaArray[i + 1].Copy();
            manaArray[31] = null;
            quantManaTotal--;
        }
        //else: error, el mana no esta dins l'array;
    }
}
