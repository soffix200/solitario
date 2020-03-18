/**
 * Representa el juego del solitario, con sus reglas.
 * Se recomienda una implementación modular.
 */

package solitario.IU;

import solitario.Core.Jugador;

/**
 * @author AEDI
 * @author Santiago Pérez Acuña
 * @author Samuel Pampillón Roa
 */
public class Solitario {
    
    private static enum Status {DEFAULT, WIN, LOOSE};
    private static Status status = Status.DEFAULT;

    public static void inicioPartida() {

        Jugador player = new Jugador();

        do {
            System.out.println(player.getMesa());
            try {
                player.moveCard(player.selectOrigin(), player.selectDestination());
                evaluateGame();
            } catch (Exception exc){
                System.err.println("ERROR: " + exc.getMessage());
            }
        } while (status == Status.DEFAULT);
        
        if (status == Status.WIN){
            System.out.println("ENHORABUENA, HAS GANADO!!");
        } else System.out.println("HAS PERDIDO EL JUEGO!!");

    }
    
    public static void evaluateGame(){
        
        if (true /* los montones exteriores contienen todas las cartas */){
            status = Status.WIN;
        } else if (true /* quedan cartas en la zona interior */){
            if (true /* no hay más movimientos posibles */) {
                status = Status.LOOSE;
            }
        } else status = Status.DEFAULT;
        
    }

}