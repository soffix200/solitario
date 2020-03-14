/*
 * Representa una carta, formada por un número y su palo correspondiente
 */
package solitario.Core;

/**
 *
 * @author AEDI
 */
public class Carta{
    
    private int num;
    private Palos palo;
    private Carta siguiente;

    public Carta(int num, Palos palo, Carta siguiente){
        this.num = num;
        this.palo = palo;
        this.siguiente = siguiente;
    }

    public int getNum() {
        return num;
    }
    public Palos getPalo() {
        return palo;
    }
    public Carta getSig() {
        return siguiente;
    }
    
    public void setSig(Carta siguiente) {
        this.siguiente = siguiente;
    }

}
