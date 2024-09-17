public class Nodo implements  Comparable<Nodo> { 
	
	
    public int frecuencia; 
    public Nodo izquierdo, derecho; 
    public String character; 
    
    //constructor
    public Nodo(int frecuencia,String character) {
        this.frecuencia = frecuencia;
        this.character = character;
        this.derecho = null;
        this.izquierdo = null;

    }

    //hace que se compare en el minHeap por la frecuencia, sino no funciona
    //porque enteinde que es la letra por defecto
    @Override
    public int compareTo(Nodo otroNodo) {
        return Integer.compare(this.frecuencia, otroNodo.frecuencia);
    }

    
    //lo uso para imprimir el a:2  b:3
    public String getTotal() {
        return String.format("%s:%d", character, frecuencia);
    }

}

