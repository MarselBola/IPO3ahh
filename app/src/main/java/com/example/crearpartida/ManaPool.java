package com.example.crearpartida;


public class ManaPool {

    private int rowTotal;           //files a mostrar a ManaTotal
    private int rowAvaiable;        //files a mostrar a PoolFragment
    private int rowSpent;           //files a mostrar a mana gastant, dins de ManaAvaible; Spent == Wasted
    private int quantManaTotal;     //quantitat total de diferents tipus de mana de l'usuari
    private int quantManaSpent;
    private Mana[] manaArray;       //llista de tot el mana posible
    private Mana[] manaSpent;       //utilitza el total del mana com a comptador
    private Mana[] manaCheckpoint;


    /**
     * Constructor de la classe ManaPool
     * Inicialitza totes les variables de classe a 0
     * Crea la array de manas
     */
    public ManaPool(){
        rowTotal = 0;
        rowAvaiable = 0;
        rowSpent = 0;
        quantManaTotal = 0;
        quantManaSpent = 0;
        manaArray = new Mana[32];
        manaSpent = new Mana[32];
    }

    /**
     * Constructor de la classe ManaPool
     * Inicialitza totes les variables de classe a 0
     * Crea la array de manas
     */
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
    }

    /**
     * Getter de les files totals del mana disponible
     * @return rowAvaiable
     */
    public int getRowAvaiable() {
        return rowAvaiable;
    }

    /**
     * Getter de les files totals del mana a gastar
     * @return rowSpent
     */
    public int getRowSpent() {
        return rowSpent;
    }

    /**
     * Getter de les files totals del mana total
     * @return rowTotal
     */
    public int getRowTotal()
    {
        return rowTotal;
    }

    /**
     * Getter de la quantitat de mana total del jugador
     * @return quantManaTotal
     */
    public int getQuantManaTotal()
    {
        return quantManaTotal;
    }

    public int getQuantManaSpent()
    {
        return this.quantManaSpent;
    }
    /**
     * Getter de la array de mana del jugador
     * @return manaArray
     */
    public Mana[] getManaArray()
    {
        return manaArray;
    }

    /**
     * Getter de la array de mana gastat del jugador
     * @return manaSpent
     */
    public Mana[] getManaSpent()
    {
        return manaSpent;
    }

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
     * Afegeix un mana a la manaArray del jugador.
     * si ja es troba dins l'array, augmenta la seva...
     * ...quantitat de mana d'aquest tipus
     * @param mana
     */
    public void addManaAtArray(Mana mana)
    {
        int pos = getManaPosition(mana, getManaArray(), getQuantManaTotal());
        if(pos == -1)
        {
            //si pos == -1 vol dir que no ha trobat el mana dins l'array
            manaArray[quantManaTotal] = mana;
            quantManaTotal++;
            if(quantManaTotal % 4 == 1) rowTotal++;
            if(quantManaTotal % 2 == 1) rowAvaiable ++;
        }
        else manaArray[pos].addTotalMana(mana.getTotal()); //augmentem el nombre de mana del tipus
    }

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
    public void removeManaFromArray(Mana mana)
    {
        int pos = getManaPosition(mana, getManaArray(), getQuantManaTotal());
        if(pos == -1); //error, el mana no esta dins l'array;
        else{
            for (int i = pos; i < 31; i++) //desplaça tots els elements de la array un pos endevant
                manaArray[i] = manaArray[i + 1].Copy();
            manaArray[31] = null;
            quantManaTotal--;
        }
    }

    /**
     * Comprova si el mana que es vol introduir a la manaArray...
     * ...ja esta dins d'aquesta
     * @param mana
     * @return true if it pertains, false otherwise
     */
            /*
            private boolean insideArray(Mana mana){
                for(int i = 0; i < quantManaTotal; i++){
                    if(manaArray[i].isEqual(mana)) return true;
                }
                return false;
            }
            */
    //aquesta comprovacio ja la fem dins de getManaPosition

}
