package solitario.IU;

import java.util.Scanner;

/**
 * @author AEDI
 */
public class ES{

    public static Scanner leer = new Scanner(System.in);

    public static String pideCadena(String mensaje) {

        // Poner el mensaje
        System.out.print(mensaje);

        // Pedir
        return leer.nextLine();

    }

    public static int pideNumero(String mensaje) {

        int a = 0;
        boolean esNumero = false;

        // Pedir
        do {
            try {
                a = Integer.parseInt(pideCadena(mensaje));
                esNumero = true;
            } catch (NumberFormatException exc) {
                System.err.println("Se esperaba un numero" + "\n");
            }
        } while (!esNumero);

        return a;
        
    }
    
}