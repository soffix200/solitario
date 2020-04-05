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
    
    private static enum Status {DEFAULT, WIN, LOSE};
    private static Status status = Status.DEFAULT;

    public static void inicioPartida() {
        Jugador player = new Jugador();
        System.out.println(player.getMesa());
        do {
            String res = "";
            try {
                player.moveCard(player.selectOrigin(), player.selectDestination());
                evaluateGame(player);
            } catch (Exception exc){
                res = "ERROR: " + exc.getMessage();
            } finally {
                System.out.println(player.getMesa());
                System.out.println(res); // Devuelve el error por flujo estándar, si ocurriese, para evitar salidas aleatorias por flujo de error
            }
        } while (status == Status.DEFAULT);
        if (status == Status.WIN){
            System.out.println("ENHORABUENA, HAS GANADO!!");
        } else System.out.println("HAS PERDIDO, VUELVE A INTENTRLO!!");
    }
    
    private static void evaluateGame(Jugador player) throws Exception {
        if (player.getMesa().getOutterCardCount() == 40){
            status = Status.WIN;
        } else if (!areActionsPossible(player)) {
            status = Status.LOSE;
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