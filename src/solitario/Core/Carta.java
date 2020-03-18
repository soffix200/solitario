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

    public Carta(Palos palo, int numero){
        this.palo = palo;
        this.numero = numero;
    }
    
    // Añadir solamente getters [no setters] para implementar correctamente el método toString()

}