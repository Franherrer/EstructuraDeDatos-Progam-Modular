package EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular;

public class ColaEstatica {

        private int[] datos = new int[5];
        private int frente = 0;
        private int fin = -1;

        // Meter un elemento al final de la cola
        public void encolar(int x) {
            if (estaLlena()) {
                System.out.println("¡Cola llena!");
                return;
            }
            fin++;
            datos[fin] = x;
        }

        // Sacar el elemento del frente
        public int desencolar() {
            if (estaVacia()) {
                System.out.println("La cola está vacía");
                return -1;
            }
            int valor = datos[frente];
            frente++; // Solo avanza el frente; el lugar liberado NO se reutiliza
            return valor;
        }

        // Consultar el elemento del frente SIN sacarlo
        public int peek() {
            if (estaVacia()) {
                System.out.println("La cola está vacía");
                return -1;
            }
            return datos[frente]; // No se modifica ningún apuntador
        }

        // Vacía cuando el frente pasó al fin (no hay elementos entre los dos)
        public boolean estaVacia() {
            return frente > fin;
        }

        // Llena cuando el fin está en la última posición del arreglo
        public boolean estaLlena() {
            return fin == datos.length - 1;
        }

        // Imprimir de frente a fin
        public void mostrar() {
            if (estaVacia()) {
                System.out.println("Cola vacía");
                return;
            }
            System.out.print("Frente -> ");
            for (int i = frente; i <= fin; i++) {
                System.out.print("[" + datos[i] + "] ");
            }
            System.out.println("<- Fin");
        }


}
