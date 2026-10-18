package EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular;
import EstructuraDeDatos.Estructuras_Lineales.Nodo;
public class ColaDinamica {


    private Nodo frente;
        private Nodo fin;

        public ColaDinamica() {
            this.frente = null;
            this.fin = null;
        }

        public boolean estaVacia() {
            return frente == null;
        }

        public void encolar(int x) {
            Nodo nuevo = new Nodo(x);
            if (estaVacia()) {
                frente = nuevo; // Si estaba vacía, el nuevo es frente y fin a la vez
                fin = nuevo;
            } else {
                fin.siguiente = nuevo; // El último actual apunta al nuevo
                fin = nuevo;           // El nuevo pasa a ser el último
            }
        }

        public int desencolar() {
            if (estaVacia()) {
                System.out.println("La cola está vacía");
                return -1;
            }
            int valor = frente.dato;
            frente = frente.siguiente;
            if (frente == null) {
                fin = null; // Si ya no quedan nodos, fin también debe quedar en null
            }
            return valor;
        }

        public void mostrar() {
            if (estaVacia()) {
                System.out.println("Cola vacía");
                return;
            }
            Nodo actual = frente;
            System.out.print("Frente -> ");
            while (actual != null) {
                System.out.print("[" + actual.dato + "] ");
                actual = actual.siguiente;
            }
            System.out.println("<- Fin");
        }

        // ===== MÉTODOS NUEVOS DE LA PRÁCTICA =====

        // Consultar el valor del frente SIN desvincular el nodo
        public int peek() {
            if (estaVacia()) {
                System.out.println("La cola está vacía");
                return -1;
            }
            return frente.dato; // Solo lee; frente y fin no cambian
        }

        // Contar cuántos nodos hay recorriendo la cola de frente a fin
        public int contarElementos() {
            int contador = 0;
            Nodo actual = frente;     // El explorador arranca en el frente
            while (actual != null) {  // Mientras no lleguemos al final (null)
                contador++;
                actual = actual.siguiente;
            }
            return contador;
        }
    }

