/*
 * Representa una carta, formada por un número y su palo correspondiente
 */

package solitario.Core;

/**
 * @author AEDI
 * @author Iago Barreiro Río
 */
public class Carta {
    
    private Palos palo;
    private int numero;    

    public Carta(Palos palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public Palos getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        toret.append("[");
        toret.append(getNumero());
        toret.append(" | ").append(getPalo()).append("]");
        return toret.toString();
    }

}