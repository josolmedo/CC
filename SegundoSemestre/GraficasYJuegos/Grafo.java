import java.util.*;

public class Grafo { //Clase (plantilla creadora de objetos)

    private Map<Integer, List<Integer>> adyacencia; //Atributos (un hashmap: llave (entero), valor(arreglo dinamico))

    public Grafo() { // Constructor
        this.adyacencia = new HashMap<>();
    }

    public void agregarVertice(int v) {
        adyacencia.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(int v1, int v2) {
        adyacencia.putIfAbsent(v1, new ArrayList<>());
        adyacencia.putIfAbsent(v2, new ArrayList<>());
        adyacencia.get(v1).add(v2);
        adyacencia.get(v2).add(v1); // Elimina esta línea si el grafo es dirigido
    }

    public List<Integer> obtenerVecinos(int v) {
        return adyacencia.getOrDefault(v, new ArrayList<>());
    }

    public void imprimirGrafo() {
        for (var entrada : adyacencia.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        grafo.imprimirGrafo();
    }
}
