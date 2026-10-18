package EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular;

public class MainColaDinamica
    {
        public static void main (String[]args){
        ColaDinamica cola = new ColaDinamica();

        System.out.println("=== COLA DINAMICA ===");
        System.out.println("¿Vacía? " + cola.estaVacia());
        System.out.println("Elementos: " + cola.contarElementos());
        cola.mostrar();

        System.out.println("\n--- Encolando 10, 20, 30, 40, 50 y 60 ---");
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.encolar(40);
        cola.encolar(50);
        cola.encolar(60); // Aquí SÍ cabe: no hay capacidad fija
        cola.mostrar();
        System.out.println("Frente (peek): " + cola.peek());
        System.out.println("Elementos: " + cola.contarElementos());

        System.out.println("\n--- Desencolando dos elementos ---");
        System.out.println("Salió: " + cola.desencolar());
        System.out.println("Salió: " + cola.desencolar());
        cola.mostrar();
        System.out.println("Elementos: " + cola.contarElementos());

        System.out.println("\n--- Sin límite de capacidad ---");
        cola.encolar(70);
        cola.encolar(80);
        cola.encolar(90);
        cola.mostrar();
        System.out.println("Elementos: " + cola.contarElementos());

        System.out.println("\n--- Vaciando la cola ---");
        for (int i = 0; i < 7; i++) {
            System.out.println("Salió: " + cola.desencolar());
        }
        System.out.println("¿Vacía? " + cola.estaVacia());
        System.out.println("Elementos: " + cola.contarElementos());
        cola.desencolar(); // Cola vacía
        cola.peek();
    }

}
