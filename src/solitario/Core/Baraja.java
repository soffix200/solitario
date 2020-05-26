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
    
    public static final int NUMCARTAS = 48;
    
    private Stack<Carta> cartas;
    
    public Baraja(){
        cartas = new Stack<>();
        for (int i = 1; i <= (NUMCARTAS/Palos.values().length); i++){
            for(Palos palo : Palos.values()){
                cartas.add(new Carta(palo, i));
            }
        }
        Collections.shuffle(cartas);
    }
    
    public boolean esVacia(){
        return cartas.isEmpty();
    }
    
    public Carta popCarta(){
        return cartas.pop();
    }
    
}