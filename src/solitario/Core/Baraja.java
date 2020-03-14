/*
* Representa la baraja española, 40 cartas, 4 palos, valores de las cartas de 1 a 12 (excepto 8 y 9). 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
 */
package solitario.Core;

public class Baraja {
    
    private Carta top;
    
    public Baraja(){
        top = null;
    }
    
    public Carta peek(){
        return top;
    }
    
    public Carta pop(){
        Carta actual = top;
        top = top.getSig();
        return actual;
    }
    
}
