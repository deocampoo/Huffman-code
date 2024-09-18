import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArbolHuffman {
      
      public static PriorityQueue<Nodo> rellenarHeap(ArrayList<Nodo> frecuencias) {
        PriorityQueue<Nodo> heap = new PriorityQueue<>();
        heap.addAll(frecuencias);
        return heap; //1,2,4,7
    }
      // O(n)
    public static int altura(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        int alturaIzq = altura(raiz.izquierdo);
        int alturaDer = altura(raiz.derecho);
        return Math.max(alturaIzq, alturaDer) + 1;
    }

    public static void imprimirVertical(Nodo raiz) {
        if (raiz == null) {
            return;
        }

        int altura = altura(raiz);
        int maxAnchoNodo = calcularMaxAnchoNodo(raiz);

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        // Reducimos el espacio inicial para acercar más los nodos a la izquierda
        int espaciosIniciales = (int) Math.pow(2, altura - 1) * maxAnchoNodo / 2;

        for (int nivel = 0; nivel < altura; nivel++) {
            int nodosEnNivel = (int) Math.pow(2, nivel);
            // Reducimos el espacio entre nodos para acercar más los números
            int espacioEntreNodos = (int) Math.pow(2, altura - nivel - 1) * maxAnchoNodo;

            // Ajuste de los espacios iniciales
            for (int i = 0; i < espaciosIniciales; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < nodosEnNivel; i++) {
                if (!cola.isEmpty()) {
                    Nodo nodoActual = cola.poll();
                    if (nodoActual != null) {
                        System.out.printf("%-" + maxAnchoNodo + "s", nodoActual.getTotal());
                        cola.add(nodoActual.izquierdo);
                        cola.add(nodoActual.derecho);
                    } else {
                        System.out.printf("%-" + maxAnchoNodo + "s", " ");
                        cola.add(null);
                        cola.add(null);
                    }
                }

                // Ajustamos el espaciado entre nodos
                for (int j = 0; j < espacioEntreNodos - maxAnchoNodo; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println(); // Nueva línea para el siguiente nivel
            // Reducimos el espacio inicial progresivamente
            espaciosIniciales /= 2;
        }
    }

    public static int calcularMaxAnchoNodo(Nodo raiz) {
        if (raiz == null) return 0;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        int maxAncho = 0;

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();
            if (nodoActual != null) {
                int anchoNodo = nodoActual.getTotal().length();
                maxAncho = Math.max(maxAncho, anchoNodo);
                cola.add(nodoActual.izquierdo);
                cola.add(nodoActual.derecho);
            }
        }

        return maxAncho;
    }
      // O(n log n)
    public static Nodo ConstruirArbol(PriorityQueue<Nodo> heap) {
      //while O(n)  
      while (heap.size() > 1) {
            //poll() O(logn)
            Nodo izquierdo = heap.poll();
            Nodo derecho = heap.poll();

            Nodo NodoNuevo = new Nodo(izquierdo.frecuencia + derecho.frecuencia, "*");
            NodoNuevo.izquierdo = izquierdo;
            NodoNuevo.derecho = derecho;
            //add() O(log n)
            heap.add(NodoNuevo);
        }

        return heap.poll();
    }

    public static void main(String[] args) {
        ArrayList<Nodo> misFrecuencias = new ArrayList<>();
        misFrecuencias.add(new Nodo(2, "a"));
        misFrecuencias.add(new Nodo(1, "b"));
        misFrecuencias.add(new Nodo(4, "c"));
        misFrecuencias.add(new Nodo(7, "d"));

        PriorityQueue<Nodo> miHeap = rellenarHeap(misFrecuencias);
        Nodo miNodoRaiz = ConstruirArbol(miHeap);

        imprimirVertical(miNodoRaiz);
    }
    
}
