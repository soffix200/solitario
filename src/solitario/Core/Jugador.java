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
    
    public void startMesa() {
        Baraja baraja = new Baraja();
        for (int i = 0; i < Baraja.NUMCARTAS; i++){
            // Disponer cartas en mesa según enunciado
            // empaceCard(baraja.popCarta(), mesa.getMonton**(**))
        }
    }

    public Mesa getMesa() {
        return mesa;
    }
    
    public void emplaceCard(Carta carta, Stack<Carta> destination){
        destination.push(carta);
    }
    
    public void moveCard(Stack<Carta> origin, Stack<Carta> destination){ // @victor
        // Decide si invocar a moveCardIn() o moveCardOut()
    }
    
    public void moveCardIn(Stack<Carta> origin, Stack<Carta> destination){ // @victor
        /*
        try{
            // if carta can be placed in destination
            if (destination.peek().getNumero()+1 == origin.peek())
            destination.push(origin.peek());
        } catch (Exception exc){
            System.err.println("La carta no se pudo mover: " + exc.getMessage());
        }
        origin.pop();
        */
    }
    
    public void moveCardOut(Stack<Carta> origin, Stack<Carta> destination){ // @victor
        /*
        try{
            // if carta can be placed in destination
            if (destination.peek().getNumero()+1 == origin.peek())
            destination.push(origin.peek());
        } catch (Exception exc){
            System.err.println("La carta no se pudo mover: " + exc.getMessage());
        }
        origin.pop();
        */
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