/**
 * Representa el juego del solitario, con sus reglas.
 * Se recomienda una implementación modular.
 */

package solitario.IU;

import solitario.Core.Jugador;
import solitario.Core.Palos;

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
        System.out.println(player.getMesa());
        if (status == Status.WIN){
            System.out.println("ENHORABUENA, HAS GANADO!!");
        } else System.out.println("HAS PERDIDO EL JUEGO!!");
    }
    
    private static void evaluateGame(Jugador player) throws Exception {
        status = Status.LOOSE;
        if (player.getMesa().getOutterCardCount() == 40){
            status = Status.WIN;
        } else {
            if (player.getMesa().getInnerCardCount() > 0){
                if (areActionsPossible(player)){
                    status = Status.DEFAULT;
                }
            }
        }
    }
    
    private static boolean areActionsPossible(Jugador player){
        boolean possible = false;
        int i = 0;
        while (!possible && i != player.getMesa().NUMFILAS){
            int j = 0;
            while (!possible && j != player.getMesa().NUMCOLUMNAS) {
                int h = 0;
                while (!possible && h != Palos.values().length) {
                    try {
                        if (!player.getMesa().getMontonInterior(i, j).isEmpty()){
                            if (player.getMesa().getMontonExterior(h).isEmpty()){
                                if (player.getMesa().getMontonInterior(i, j).peek().getNumero() == 1){
                                    possible = true;
                                }
                            } else if (player.getMesa().getMontonExterior(h).peek().getNumero() + 1 == player.getMesa().getMontonInterior(i, j).peek().getNumero()) {
                                if (player.getMesa().getMontonExterior(h).peek().getPalo() == player.getMesa().getMontonInterior(i, j).peek().getPalo()){
                                    possible = true;
                                }
                            }
                        }
                    } catch (Exception exc){
                        System.err.println("ERROR: " + exc.getMessage());
                    }
                    h++;
                }
                int k = 0;
                while (!possible && k != player.getMesa().NUMFILAS) {
                    int l = 0;
                    while (!possible && l != player.getMesa().NUMCOLUMNAS) {
                        try {
                            if (!player.getMesa().getMontonInterior(i, j).isEmpty()){
                                if (!player.getMesa().getMontonInterior(k, l).isEmpty()) {
                                    if (player.getMesa().getMontonInterior(k, l).peek().getNumero() - 1 == player.getMesa().getMontonInterior(i, j).peek().getNumero()) {
                                        if (player.getMesa().getMontonInterior(k, l).peek().getPalo() == player.getMesa().getMontonInterior(i, j).peek().getPalo()){
                                            possible = true;
                                        }
                                    }
                                }
                            }
                        } catch (Exception exc) {
                            System.err.println("ERROR: " + exc.getMessage());
                        }
                        l++;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        return possible;
    } 

}