package EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular;

public class Maincolaestatica {
        public static void main(String[] args) {
            ColaEstatica cola = new ColaEstatica();

            System.out.println("=== COLA ESTATICA LINEAL ===");
            System.out.println("¿Vacía? " + cola.estaVacia());

            System.out.println("\n--- Encolando 10, 20, 30, 40, 50 y 60 ---");
            cola.encolar(10);
            cola.encolar(20);
            cola.encolar(30);
            cola.encolar(40);
            cola.encolar(50);
            cola.encolar(60); // No cabe: la cola tiene capacidad 5
            cola.mostrar();
            System.out.println("¿Llena? " + cola.estaLlena());
            System.out.println("Frente (peek): " + cola.peek());

            System.out.println("\n--- Desencolando dos elementos ---");
            System.out.println("Salió: " + cola.desencolar());
            System.out.println("Salió: " + cola.desencolar());
            cola.mostrar();

            System.out.println("\n--- La limitación de la cola lineal ---");
            System.out.println("Ya hay 2 lugares libres al frente, pero...");
            System.out.println("¿Llena? " + cola.estaLlena());
            cola.encolar(70); // Sigue sin poder entrar

            System.out.println("\n--- Vaciando la cola ---");
            System.out.println("Salió: " + cola.desencolar());
            System.out.println("Salió: " + cola.desencolar());
            System.out.println("Salió: " + cola.desencolar());
            System.out.println("¿Vacía? " + cola.estaVacia());
            cola.desencolar(); // Cola vacía
            cola.peek();
        }

}
