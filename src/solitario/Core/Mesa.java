/*
 Representa la mesa de juego, donde estarán todas las cartas.
 Tendrá dos partes diferenciadas:
 - la parte interior, donde inicialmente estarán colocadas las cartas correctamente para jugar al solitario
 - los montones exteriores, donde estarán colocadas las cartas por palo ordenadas de menor a mayor
 Estructura: Se utilizarán TADs adecuados para su respresentación. En concreto:
 - Una matriz de Pilas para representar la parte o montón interior 
 - Un array de Pilas para representar los montones exteriores.
 Funcionalidad: colocar las cartas para iniciar el juego, quitar una carta de la parte interior, colocar una carta en el interior,
 colocar una carta en el montón exterior correspondiente, visualizar cartas en la mesa, etc

La Pila es una estructura de datos que existe en Java y que se corresponde con la clase Stack. Por lo tanto debereis hacer uso de dicha
clase para representar la mesa de juego, y en particular de los métodos que se indican a continuación (de ser necesarios):

        public boolean empty();
           Produce: Si la pila está vacía devuelve true, sino false.
        public Carta peek();
           Produce: Devuelve la Carta del tope de la pila, sin eliminarla de ella.
        public Carta pop();
           Produce: Elimina la Carta del tope de la pila y la devuelve.
        public void push(Carta item);
           Produce: Introduce la Carta en el tope de la pila.
*/

package solitario.Core;

import java.util.Stack;

/**
 * @author AEDI
 * @author Álvaro Luis Martínez González
 */
public class Mesa {
    
    public static final int NUMFILAS = 4;
    public static final int NUMCOLUMNAS = 4;
    
    private Stack<Carta>[][] montonesInteriores;
    private Stack<Carta>[] montonesExteriores;
    
    public Mesa(){
        montonesInteriores = new Stack[NUMFILAS][NUMCOLUMNAS];
        for (int i = 0; i < montonesInteriores.length; i++){
            for (int j = 0; j < montonesInteriores[0].length; j++){
                montonesInteriores[i][j] = new Stack<>();
            }
        }
        montonesExteriores = new Stack[Palos.values().length];
        for (int i = 0; i < montonesExteriores.length; i++){
            montonesExteriores[i] = new Stack<>();
        }
    }
    
    public Stack<Carta> getMontonInterior(int i, int j) throws Exception {
        if (i >= montonesInteriores.length || i < 0 || j >= montonesInteriores[0].length || j < 0) {
            throw new Exception("Posicion invalida");
        }
        return montonesInteriores[i][j];
    }
    
    public int getInnerCardCount(){
        int toret = 0;
        for (Stack<Carta>[] filaMontones : montonesInteriores){
            for (Stack<Carta> monton : filaMontones){
                toret += monton.size();
            }
        }
        return toret;
    }

    public Stack<Carta> getMontonExterior(int i) throws Exception {
        if (i >= montonesExteriores.length || i < 0) {
            throw new Exception("Posicion invalida");
        }
        return montonesExteriores[i];
    }
    
    public int getOutterCardCount() {
        int toret = 0;
        for (Stack<Carta> monton : montonesExteriores) {
            toret += monton.size();
        }
        return toret;
    }
    
    public String toString() { // Hacer cosa más visual que esta vaina
        StringBuilder toret = new StringBuilder("\n\n\n\n\n\n\n\n\n");
        int contador = 1;

        toret.append("\n********************************************** MONTONES INTERIORES **********************************************\n");
        //Del 1 al 12
        for (int u = 0; u < montonesInteriores.length - 1; u++) {
            for (int j = 0; j < montonesInteriores[u].length; j++) {
                toret.append("Monton: ").append(contador).append("\t\t\t");
                contador++;
            }
            toret.append("\n");
            for (int i = 0; i < montonesInteriores[u].length; i++) {
                //If monton vacio{append("Monton Vacio\t\t\t") }else{ toret.append("Palo | ").append("Numero\t\t\t");}
                if (montonesInteriores[u][i].isEmpty()) {
                    toret.append("Monton Vacio\t\t\t");
                } else {
                    toret.append(montonesInteriores[u][i].peek()).append("\t\t\t");
                }
            }
            toret.append("\n-----------------------------------------------------------------------------------------------------------------\n");
        }

        //Del 13 al 16
        for (int j = 0; j < montonesInteriores.length; j++) {
            toret.append("Monton: ").append(contador).append("\t\t\t");
            contador++;
        }
        toret.append("\n");

        for (int j = 0; j < montonesInteriores.length; j++) {
            if (montonesInteriores[montonesInteriores.length - 1][j].isEmpty()) {
                toret.append("Monton Vacio\t\t\t");
            } else {
                toret.append(montonesInteriores[montonesInteriores.length - 1][j].peek()).append("\t\t\t");
            }

        }

        //Del 17 al 20
        toret.append("\n\n********************************************** MONTONES EXTERIORES **********************************************\n\n");
        for (int j = 0; j < montonesExteriores.length; j++) {
            toret.append("Monton: ").append(contador).append("\t\t\t");
            contador++;
        }
        toret.append("\n");
        for (int i = 0; i < montonesExteriores.length; i++) {
            if (montonesExteriores[i].isEmpty()) {
                toret.append("Monton Vacio\t\t\t");
            } else {
                toret.append(montonesExteriores[i].peek()).append("\t\t\t");
            }

        }

        return toret.toString();
    }
    
}