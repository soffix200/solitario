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
                evaluateGame(player);
            } catch (Exception exc){
                System.err.println("ERROR: " + exc.getMessage());
            }
        } while (status == Status.DEFAULT);
        
        if (status == Status.WIN){
            System.out.println("ENHORABUENA, HAS GANADO!!");
        } else System.out.println("HAS PERDIDO EL JUEGO!!");

    }
    
    public static void evaluateGame(Jugador player) throws Exception {
        
        status = Status.LOOSE;
        
        if (player.getMesa().getOutterCardCount() == 40){
            status = Status.WIN;
        } else {
            if (player.getMesa().getInnerCardCount() > 0){
                if (true /* hay más movimientos posibles */){
                    status = Status.DEFAULT;
                }
            } else status = Status.WIN;
        }
        
    }

}