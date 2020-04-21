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
    
    public static enum Status {DEFAULT, WIN, LOSE};
    public static Status status = Status.DEFAULT;
    
    public static final int NUMFILAS = 4;
    public static final int NUMCOLUMNAS = 4;
    
    private Stack<Carta>[][] montonesInteriores;
    private Stack<Carta>[] montonesExteriores;
    
    public Mesa(){
        montonesInteriores = new Stack[NUMFILAS][NUMCOLUMNAS];
        for (int i = 0; i < NUMFILAS; i++){
            for (int j = 0; j < NUMCOLUMNAS; j++){
                montonesInteriores[i][j] = new Stack<>();
            }
        }
        montonesExteriores = new Stack[Palos.values().length];
        for (int i = 0; i < Palos.values().length; i++){
            montonesExteriores[i] = new Stack<>();
        }
        startMesa();
    }
    
    private void startMesa() {
        Baraja baraja = new Baraja();
        try {
            // Se colocan las 16 primeras cartas (4x4)
            for (int i = 0; i < NUMFILAS; i++) {
                for (int j = 0; j < NUMCOLUMNAS; j++) {
                    emplaceCarta(baraja.popCarta(), new Position(i,j));
                }
            }
            // Se colocan las 8 cartas de las diagonales
            for (int i = 0; i < NUMFILAS; i++) {
                emplaceCarta(baraja.popCarta(), new Position(i,i));
                emplaceCarta(baraja.popCarta(), new Position(i, NUMFILAS-i-1));
            }
            // Se colocan las 16 últimas cartas (4x4)
            for (int i = 0; i < NUMFILAS; i++) {
                for (int j = 0; j < NUMCOLUMNAS; j++) {
                    emplaceCarta(baraja.popCarta(), new Position(i,j));
                }
            }
        } catch (Exception exc){
            System.err.println("ERROR: " + exc.getMessage());
        }
    }
    
    public Carta popCarta(Position pos) throws Exception {
        if (montonesInteriores[pos.getI()][pos.getJ()].isEmpty()){
            throw new Exception("Montón vacío");
        }
        return montonesInteriores[pos.getI()][pos.getJ()].pop();
    }
    
    public void pushCarta(Carta carta, Position pos) throws Exception {
        if (pos.getI() >= NUMFILAS) { // Si destination es exterior
            if (montonesExteriores[pos.getJ()].isEmpty()) {
                if (carta.getNumero() == 1) {
                    montonesExteriores[pos.getJ()].push(carta);
                } else {
                    throw new Exception("No se puede mover una carta distinta de 1 a un montón exterior vacío");
                }
            } else {
                if ((montonesExteriores[pos.getJ()].peek().getNumero() == carta.getNumero() - 1) && (montonesExteriores[pos.getJ()].peek().getPalo() == carta.getPalo())) {
                    montonesExteriores[pos.getJ()].push(carta);
                } else {
                    throw new Exception("La carta no se puede mover al montón indicado");
                }
            }
        } else { // Si destination es interior
            if (montonesInteriores[pos.getI()][pos.getJ()].isEmpty()) {
                System.err.println("No se pueden mover cartas a montones vacíos en el interior del tablero");
            } else {
                if ((montonesInteriores[pos.getI()][pos.getJ()].peek().getNumero() == carta.getNumero() + 1) && (montonesInteriores[pos.getI()][pos.getJ()].peek().getPalo() == carta.getPalo())) {
                    montonesInteriores[pos.getI()][pos.getJ()].push(carta);
                } else {
                    throw new Exception("La carta no se puede mover al montón indicado");
                }
            }
        }
    }
    
    public void emplaceCarta(Carta carta, Position pos) {
        montonesInteriores[pos.getI()][pos.getJ()].push(carta);
    }
    
    public int getOutterCardCount() {
        int toret = 0;
        for (Stack<Carta> monton : montonesExteriores) {
            toret += monton.size();
        }
        return toret;
    }
       
    public void evaluateGame() {
        if (getOutterCardCount() == 40){
            status = Status.WIN;
        } else if (!areActionsPossible()) {
            status = Status.LOSE;
        }
    }
    
    private boolean areActionsPossible(){
        boolean possible = false;
        int i = 0;
        while (!possible && i != NUMFILAS){
            int j = 0;
            while (!possible && j != NUMCOLUMNAS) {
                int h = 0;
                while (!possible && h != Palos.values().length) {
                    try {
                        if (!montonesInteriores[i][j].isEmpty()){
                            if (montonesExteriores[h].isEmpty()){
                                if (montonesInteriores[i][j].peek().getNumero() == 1){
                                    possible = true;
                                }
                            } else if (montonesExteriores[h].peek().getNumero() + 1 == montonesInteriores[i][j].peek().getNumero()) {
                                if (montonesExteriores[h].peek().getPalo() == montonesInteriores[i][j].peek().getPalo()){
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
                while (!possible && k != NUMFILAS) {
                    int l = 0;
                    while (!possible && l != NUMCOLUMNAS) {
                        try {
                            if (!montonesInteriores[i][j].isEmpty()){
                                if (!montonesInteriores[k][l].isEmpty()) {
                                    if (montonesInteriores[k][l].peek().getNumero() - 1 == montonesInteriores[i][j].peek().getNumero()) {
                                        if (montonesInteriores[k][l].peek().getPalo() == montonesInteriores[i][j].peek().getPalo()){
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
    
    
    public String rowToString(int i){
        StringBuilder toret = new StringBuilder();
        // LINE 1
        toret.append("\n==");
        for (int j = 0; j < ((i != NUMFILAS) ? NUMCOLUMNAS : Palos.values().length); j++) {
            toret.append("========================");
        }
        // LINE 2
        toret.append("\n||");
        for (int j = 0; j < ((i!=NUMFILAS)? NUMCOLUMNAS : Palos.values().length); j++){
            toret.append("  Montón ").append((i*NUMCOLUMNAS)+j+1).append("\t\t||");
        }
        // LINE 3
        toret.append("\n||");
            for (int j = 0; j < ((i!=NUMFILAS)? NUMCOLUMNAS : Palos.values().length); j++){
                toret.append("                      ||");
            }
        // LINE 4
        toret.append("\n||");
        if (i != NUMFILAS){
            for (int j = 0; j < NUMCOLUMNAS; j++){
                toret.append("\t");
                if (montonesInteriores[i][j].isEmpty()) {
                    toret.append("  [VACIO]").append("\t||");
                } else {
                    toret.append(montonesInteriores[i][j].peek()).append("\t||");
                }
            }
        } else {
            for (int j = 0; j < Palos.values().length; j++){
                toret.append("\t");
                if (montonesExteriores[j].isEmpty()) {
                    toret.append("  [VACIO]").append("\t||");
                } else {
                    toret.append(montonesExteriores[j].peek()).append("\t||");
                }
            }
        }
        
        return toret.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        // MONTONES INTERIORES
        toret.append("\n|||||||||||||||||||||||||||||||||||||| MONTONES INTERIORES |||||||||||||||||||||||||||||||||||||||\n");
        for (int i = 0; i < montonesInteriores.length; i++){
            toret.append(rowToString(i));
        }
        toret.append("\n==");
        for (int j = 0; j < NUMCOLUMNAS; j++) {
            toret.append("========================");
        }
        
        // MONTONES EXTERIORES
        toret.append("\n\n|||||||||||||||||||||||||||||||||||||| MONTONES EXTERIORES |||||||||||||||||||||||||||||||||||||||\n");
        toret.append(rowToString(NUMFILAS));
        toret.append("\n==");
        for (int j = 0; j < Palos.values().length; j++) {
            toret.append("========================");
        }
        
        return toret.toString();
    }

    
}