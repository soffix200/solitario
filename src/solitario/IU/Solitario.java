/**
 * Representa el juego del solitario, con sus reglas.
 * Se recomienda una implementación modular.
 */

package solitario.IU;

import solitario.Core.Carta;
import solitario.Core.Jugador;
import solitario.Core.Mesa;
import solitario.Core.Palos;
import solitario.Core.Position;

/**
 * @author AEDI
 * @author Santiago Pérez Acuña
 * @author Samuel Pampillón Roa
 */
public class Solitario {
    
    private static Position selectInnerPosition() {
        int i = 0;
        while (i < 1 || i > Mesa.NUMFILAS*Mesa.NUMCOLUMNAS) {
            i = ES.pideNumero("\nIntroduczca el monton [1 - " + Mesa.NUMFILAS*Mesa.NUMCOLUMNAS + "]: ");
            if (i < 1 || i > Mesa.NUMFILAS*Mesa.NUMCOLUMNAS) System.err.println("Se esperaba un número [1 - " + Mesa.NUMFILAS*Mesa.NUMCOLUMNAS + "]" + "\n");
        }
        return new Position(--i/Mesa.NUMFILAS, i%Mesa.NUMFILAS);
    }
    private static Position selectAnyPosition() {
        int i = 0;
        while (i < 1 || i > Mesa.NUMFILAS*Mesa.NUMCOLUMNAS+Palos.values().length) {
            i = ES.pideNumero("\nIntroduczca el monton [1 - " + (Mesa.NUMFILAS*Mesa.NUMCOLUMNAS+Palos.values().length) + "]: ");
            if (i < 1 || i > Mesa.NUMFILAS*Mesa.NUMCOLUMNAS+Palos.values().length) System.err.println("Se esperaba un número [1 - " + (Mesa.NUMFILAS*Mesa.NUMCOLUMNAS+Palos.values().length) + "]" + "\n");
        }
        return new Position(--i/Mesa.NUMFILAS, i%Mesa.NUMFILAS);
    }

    public static void inicioPartida() {
        Jugador jugador = new Jugador();
        Mesa mesa = new Mesa();
        
        System.out.println(mesa);
        
        while(Mesa.status == Mesa.Status.DEFAULT){
            try {
                Position take = selectInnerPosition();
                Position drop = selectAnyPosition();
                Carta carta = jugador.takeCarta(mesa, take);
                try {
                    jugador.pushCarta(mesa, carta, drop);
                    mesa.evaluateGame();
                } catch (Exception exc) {
                    System.err.println("\nERROR. " + exc.getMessage() + "\n");
                    jugador.emplaceCarta(mesa, carta, take);
                }
            } catch (Exception exc) {
                System.err.println("\nERROR. " + exc.getMessage() + "\n");
            }
            System.out.println(mesa);
        }
                
        if (Mesa.status == Mesa.Status.WIN){
            System.out.println("ENHORABUENA, HAS GANADO!!");
        } else System.out.println("HAS PERDIDO, VUELVE A INTENTRLO!!");
    }

}