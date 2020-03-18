/**
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */

package solitario.Core;

import java.util.Stack;

/**
 * @author AEDI
 * @author Victor Figueroa Maceira
 */
public class Jugador {

    private Mesa mesa;

    public Jugador() {
        mesa = new Mesa();
    }

    public Mesa getMesa() {
        return mesa;
    }
    
    public void moveCard(Stack<Carta> origin, Stack<Carta> destination){
        try{
            destination.push(origin.peek());
        } catch (Exception exc){
            System.err.println("La carta no se pudo mover: " + exc.getMessage());
        }
        origin.pop();
    }
    
    public Stack selectOrigin() throws Exception {
        
        // Con el menú y todo el rollo
        // La Exception se lanza en Mesa.getMonton(); nohay que preocuparse aquí
        
        return new Stack<Carta>(); // TEMPORAL, PARA QUE NO SE QUEJE NETBEANS, ESTÁ SIN IMPLEMENTAR; BORRAR EN CUANTO IMPLEMENTADO
    }
    
    public Stack selectDestination() throws Exception {
        
        // Con el menú y todo el rollo
        // La Exception se lanza en Mesa.getMonton(); nohay que preocuparse aquí
        
        return new Stack<Carta>(); // TEMPORAL, PARA QUE NO SE QUEJE NETBEANS, ESTÁ SIN IMPLEMENTAR; BORRAR EN CUANTO IMPLEMENTADO
    }
    
}