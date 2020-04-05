/**
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */

package solitario.Core;

import java.util.Stack;
import solitario.IU.ES;

/**
 * @author AEDI
 * @author Victor Figueroa Maceira
 */
public class Jugador {

    private Mesa mesa;

    public Jugador() {
        mesa = new Mesa();
        startMesa();
    }
    
    public void startMesa() {
        Baraja baraja = new Baraja();
        // Se colocan las 16 primeras cartas (4x4)
        for (int i = 0; i < mesa.NUMFILAS; i++){
            for (int j = 0; j < mesa.NUMCOLUMNAS; j++){
                try{
                    emplaceCard(baraja.popCarta(), mesa.getMontonInterior(i, j));
                } catch(Exception exc){
                    System.err.println("ERROR: " + exc.getMessage());
                }
            }
        }
        // Se colocan las 8 cartas de las diagonales
        for (int i = 0; i < mesa.NUMFILAS; i++) {
            try {
                emplaceCard(baraja.popCarta(), mesa.getMontonInterior(i, i));
                emplaceCard(baraja.popCarta(), mesa.getMontonInterior(i, 3-i));
            } catch (Exception exc) {
                System.err.println("ERROR: " + exc.getMessage());
            }
        }
        // Se colocan las 16 últimas cartas (4x4)
        for (int i = 0; i < mesa.NUMFILAS; i++){
            for (int j = 0; j < mesa.NUMCOLUMNAS; j++){
                try{
                    emplaceCard(baraja.popCarta(), mesa.getMontonInterior(i, j));
                } catch(Exception exc){
                    System.err.println("ERROR: " + exc.getMessage());
                }
            }
        }
    }

    public Mesa getMesa() {
        return mesa;
    }
    
    public void emplaceCard(Carta carta, Stack<Carta> destination){
        destination.push(carta);
    }
    
    public void moveCard(Stack<Carta> origin, Pair<Stack<Carta>,Boolean> destination) throws Exception {
        if (!origin.isEmpty()){ // Si hay al menos una carta para mover en origin
            if (destination.second) { // Si destination es exterior
                if (destination.first.isEmpty()){
                    if (origin.peek().getNumero() == 1){
                        emplaceCard(origin.pop(), destination.first);
                    } else {
                        throw new Exception("No se puede mover una carta distinta de 1 a un montón exterior vacío");
                    }
                } else {
                    if ((destination.first.peek().getNumero() == origin.peek().getNumero()-1) && (destination.first.peek().getPalo() == origin.peek().getPalo())){
                        emplaceCard(origin.pop(), destination.first);
                    } else {
                        throw new Exception("La carta no se puede mover al montón indicado");
                    }
                }
            } else { // Si destination es interior
                if (destination.first.isEmpty()) {
                    System.err.println("No se pueden mover cartas a montones vacíos en el interior del tablero");
                } else {
                    if ((destination.first.peek().getNumero() == origin.peek().getNumero()+1) && (destination.first.peek().getPalo() == origin.peek().getPalo())){
                        emplaceCard(origin.pop(), destination.first);
                    } else {
                        throw new Exception("La carta no se puede mover al montón indicado");
                    }
                }
            }
        } else {
            throw new Exception("No hay carta para mover");
        }
    }
    
    public Stack selectOrigin() throws Exception {
        int i = 0;
        while (i < 1 || i > 16) {
            i = ES.pideNumero("\nIntroduczca el monton desde el que se moverá la carta [1 - 16]: ");
            if (i < 1 || i > 16) System.err.println("Se esperaba un número [1 - 16]");
        }
        return mesa.getMontonInterior(--i/4, i%4);
    }
    
    public Pair<Stack<Carta>, Boolean> selectDestination() throws Exception {
        int i = 0;
        while (i < 1 || i > 20) {
            i = ES.pideNumero("\nIntroduczca el monton al que se movera la carta [1 - 20]: ");
            if (i < 1 || i > 20) throw new Exception("Se esperaba un número [1 - 20]");
        }
        
        Pair<Stack<Carta>, Boolean> destino;
        if (--i/4 == 4) {
            destino = Pair.of(mesa.getMontonExterior(i%4), true); // TRUE si es exterior
        } else {
            destino = Pair.of(mesa.getMontonInterior(i/4, i%4), false); // FALSE si es interior
        }
        return destino;
    }
    
}