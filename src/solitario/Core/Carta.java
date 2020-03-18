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

    public Carta(Palos palo, int numero) throws Exception {
        if ((palo != Palos.BASTOS  && palo != Palos.COPAS && palo != Palos.ESPADAS && palo != Palos.OROS)
                || ((numero < 1 || numero > 12 || numero > 7 && numero < 10)))
            throw new Exception("Carta inválida");

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
        toret.append("[").append(getNumero()).append(" | ").append(getPalo()).append("]");
        return toret.toString();
    }

}