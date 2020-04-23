/**
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */

package solitario.Core;

/**
 * @author AEDI
 * @author Victor Figueroa Maceira
 */
public class Jugador {
    
    public Carta takeCarta(Mesa mesa, Position pos) throws Exception {
        return mesa.popCarta(pos);
    }
    
    public void pushCarta(Mesa mesa, Carta carta, Position pos) throws Exception {
        mesa.pushCarta(carta, pos);
    }
    
    public void emplaceCarta(Mesa mesa, Carta carta, Position pos) throws Exception {
        mesa.emplaceCarta(carta, pos);
    }
    
}