package EstructuraDeDatos.Estructuras_Lineales;

public class Nodo {
    public int dato;
    public Nodo siguiente; // La flechita que apunta al siguiente nodo

    // Constructor del nodo
    public Nodo(int x) {
        this.dato = x;         // Para que nazca con un valor y no con basura
        this.siguiente = null; // Al nacer, no apunta a nadie todavía
    }
}