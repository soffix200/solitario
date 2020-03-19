/*
* Representa la baraja española, 40 cartas, 4 palos, valores de las cartas de 1 a 12 (excepto 8 y 9). 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
*/

package solitario.Core;

import java.util.Collections;
import java.util.Stack;

/**
 * @author AEDI
 * @author Iago Barreiro Río
 */
public class Baraja {
    
    public static final int NUMCARTAS = 40;
    
    private Stack<Carta> cartas;
    
    public Baraja(){
        cartas = new Stack<>();
        for (int i = 1; i <= (NUMCARTAS/Palos.values().length); i++){
            for(Palos palo : Palos.values()){
                try {
                    cartas.add(new Carta(palo, i));
                } catch (Exception exc) {
                    System.err.println("ERROR: " + exc.getMessage());
                }
            }
        }
        Collections.shuffle(cartas); // Pensar en método más ortodoxo
    }
    
    public boolean esVacia(){
        return cartas.isEmpty();
    }
    
    public Carta popCarta(){
        return cartas.pop();
    }
    
}