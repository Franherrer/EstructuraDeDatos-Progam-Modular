package EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular;

public class ColaEstaticacircular {


        private int[] datos = new int[5];
        private int frente = 0;
        private int fin = -1;
        private int tamano = 0;

        // Meter un elemento al final de la cola
        public void encolar(int x) {
            if (estaLlena()) {
                System.out.println("¡Cola llena!");
                return;
            }
            fin = (fin + 1) % datos.length; // Si llega al final del arreglo, vuelve a 0
            datos[fin] = x;
            tamano++;
        }

        // Sacar el elemento del frente
        public int desencolar() {
            if (estaVacia()) {
                System.out.println("La cola está vacía");
                return -1;
            }
            int valor = datos[frente];
            frente = (frente + 1) % datos.length; // El frente también da la vuelta
            tamano--;
            return valor;
        }

        // Consultar el elemento del frente SIN sacarlo
        public int peek() {
            if (tamano == 0) {                 // Si está vacía no hay nada que ver
                System.out.println("La cola está vacía");
                return -1;
            }
            return datos[frente];              // Solo lee; no modifica frente, fin ni tamano
        }

        public boolean estaVacia() {
            return tamano == 0;
        }

        public boolean estaLlena() {
            return tamano == datos.length;
        }

        // Imprimir de frente a fin (recorre solo los elementos que hay)
        public void mostrar() {
            if (estaVacia()) {
                System.out.println("Cola vacía");
                return;
            }
            System.out.print("Frente -> ");
            for (int i = 0; i < tamano; i++) {
                System.out.print("[" + datos[(frente + i) % datos.length] + "] ");
            }
            System.out.println("<- Fin");
        }

}
