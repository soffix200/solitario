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
    
    private Stack<Carta> [][] montonesInteriores;
    private Stack<Carta> [] montonesExteriores;
    
    public Mesa(){
        
        // NO SE DETALLA; DEMASIADO COMPLEJO
        
    }
    
    public Stack getMonton(/* Indice del montón */) throws Exception {
        
        // Es necesario indexar de alguna manera sencilla los montones, para saber fácilmente a cuál es necesario acceder
        //  -> Pensar en algo XD
        
        // Lanza Excption("Wrong hole") si el montón objetivo no es válido
        
        return new Stack<Carta>(); // TEMPORAL, PARA QUE NO SE QUEJE NETBEANS, ESTÁ SIN IMPLEMENTAR; BORRAR EN CUANTO IMPLEMENTADO
    }
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        // NO SE DETALLA; DEMASIADO COMPLEJO
        
        return toret.toString();
    }
    
}