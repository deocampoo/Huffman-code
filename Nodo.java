public class Nodo implements  Comparable<Nodo> { 
	
	
    public int frecuencia; 
    public Nodo izquierdo, derecho; 
    public String character; 
    
    //constructor    
    //---> costo: O(1): La creación de un nuevo nodo y la asignación de valores a los atributos se realiza en tiempo constante, ya que no depende del tamaño de ninguna colección.

    public Nodo(int frecuencia,String character) {
        this.frecuencia = frecuencia;
        this.character = character;
        this.derecho = null;
        this.izquierdo = null;

    }

    //hace que se compare en el minHeap por la frecuencia, sino no funciona
    //porque enteinde que es la letra por defecto
    //---> costo: O(1): La comparación de dos enteros es una operación que se realiza en tiempo constante.
    @Override
    public int compareTo(Nodo otroNodo) {
        //---> La función Integer.compare() simplemente compara los valores de frecuencia de dos nodos, lo cual no depende del tamaño de la estructura de datos.
        return Integer.compare(this.frecuencia, otroNodo.frecuencia);
    }

    
    //lo uso para imprimir el a:2  b:3 
    //%s: Inserta una cadena de texto. %d: Inserta un número entero.
    //--> cosot: O(1): El método accede directamente a los atributos character y frecuencia y no depende de ninguna colección o estructura de datos.
    public String getTotal() {
        return String.format("%s:%d", character, frecuencia);
    }

}

