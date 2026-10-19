# EstructuraDeDatos-Progam-Modular
Repositorio creado para las practicas de la materia de estructura de datos /Implementando la programación modular 
# Práctica: Colas en Java (Estática, Circular y Dinámica)

##  Descripción del proyecto

Una **cola** es una estructura de datos con política **FIFO** (*First In, First Out*): el primer elemento que entra es el primero que sale. Los elementos entran por el **fin** y salen por el **frente**.

En esta práctica se implementaron tres tipos de cola, cada una con su propia clase `Main` independiente:

| Tipo de cola | Clase | Clase de prueba |
|---|---|---|
| Estática lineal (arreglo) | `ColaEstatica.java` | `MainColaEstatica.java` |
| Estática circular (arreglo) | `ColaEstaticaCircular.java` | `MainColaEstaticaCircular.java` |
| Dinámica (nodos enlazados) | `ColaDinamica.java` | `MainColaDinamica.java` |

Las tres usan los mismos nombres de métodos. La cola dinámica también utiliza la clase `Nodo.java`, la misma de la práctica de Pilas.

##  Diferencias entre las tres colas

**Cola estática lineal.** Usa un arreglo de 5 posiciones con dos índices, `frente` y `fin`. Al desencolar solo avanza `frente`, y los lugares que quedan libres al inicio **no se reutilizan**. Por eso la cola puede marcarse como llena aunque todavía haya espacio en el arreglo.

**Cola estática circular.** También usa un arreglo de 5 posiciones, pero los índices "dan la vuelta" con el operador `%` (`fin = (fin + 1) % datos.length`). Así reutiliza los lugares liberados al frente. Lleva un contador `tamano` para saber cuándo está llena o vacía.

**Cola dinámica.** Usa nodos enlazados. La cola guarda dos referencias, `frente` y `fin`, y cada nodo apunta al siguiente. Crece conforme se necesita y solo está limitada por la memoria RAM.

| Característica | Estática lineal | Estática circular | Dinámica |
|---|---|---|---|
| Memoria | Arreglo contiguo de tamaño fijo | Arreglo contiguo de tamaño fijo | Nodos dispersos, uno por elemento |
| Capacidad | 5 elementos | 5 elementos | Limitada solo por la RAM |
| ¿Reutiliza lugares liberados? | No | Sí | No aplica |
| ¿Puede llenarse? | Sí | Sí | Solo si se acaba la RAM |
| Memoria extra | Lugares sin usar | Ninguna importante | Una referencia por nodo |
| `encolar` / `desencolar` | O(1) | O(1) | O(1) |

---

##  Estructura del proyecto

```
src/
└── EstructuraDeDatos/
    └── Estructuras_Lineales/
        ├── Nodo.java
        └── Programacion_Modular/
            ├── ColaEstatica.java
            ├── ColaEstaticaCircular.java
            ├── ColaDinamica.java
            ├── MainColaEstatica.java
            ├── MainColaEstaticaCircular.java
            └── MainColaDinamica.java
```

> Los campos `dato` y `siguiente` de `Nodo` son `public`, porque las colas están en un paquete distinto (`Programacion_Modular`).

---

## Cómo compilar y ejecutar

**Requisitos:** JDK 17 o superior (se probó con JDK 17).

### Desde la terminal

Colócate dentro de la carpeta `src` y ejecuta:

```bash
# Compilar
javac EstructuraDeDatos/Estructuras_Lineales/Nodo.java EstructuraDeDatos/Estructuras_Lineales/Programacion_Modular/*.java

# Ejecutar cada prueba
java EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular.MainColaEstatica
java EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular.MainColaEstaticaCircular
java EstructuraDeDatos.Estructuras_Lineales.Programacion_Modular.MainColaDinamica
```

### Desde IntelliJ IDEA

1. Abre el proyecto y verifica que los archivos estén en `src/EstructuraDeDatos/Estructuras_Lineales/Programacion_Modular`.
2. Haz clic derecho sobre cada `Main` y elige **Run 'Main....main()'**.

---

## Ejecucion

### Cola estática lineal (`MainColaEstatica`)

```text
=== COLA ESTATICA LINEAL ===
¿Vacía? true

--- Encolando 10, 20, 30, 40, 50 y 60 ---
¡Cola llena!
Frente -> [10] [20] [30] [40] [50] <- Fin
¿Llena? true
Frente (peek): 10

--- Desencolando dos elementos ---
Salió: 10
Salió: 20
Frente -> [30] [40] [50] <- Fin

--- La limitación de la cola lineal ---
Ya hay 2 lugares libres al frente, pero...
¿Llena? true
¡Cola llena!

--- Vaciando la cola ---
Salió: 30
Salió: 40
Salió: 50
¿Vacía? true
La cola está vacía
La cola está vacía
```

### Cola estática circular (`MainColaEstaticaCircular`)

```text
=== COLA ESTATICA CIRCULAR ===
¿Vacía? true

--- Encolando 10, 20, 30, 40, 50 y 60 ---
¡Cola llena!
Frente -> [10] [20] [30] [40] [50] <- Fin
¿Llena? true
Frente (peek): 10

--- Desencolando dos elementos ---
Salió: 10
Salió: 20
Frente -> [30] [40] [50] <- Fin

--- La ventaja de la cola circular ---
Ahora hay 2 lugares libres y SÍ se pueden usar
¿Llena? false
Frente -> [30] [40] [50] [60] [70] <- Fin
¿Llena? true
Frente (peek): 30

--- Vaciando la cola ---
Salió: 30
Salió: 40
Salió: 50
Salió: 60
Salió: 70
¿Vacía? true
La cola está vacía
La cola está vacía
```

### Cola dinámica (`MainColaDinamica`)

```text
=== COLA DINAMICA ===
¿Vacía? true
Elementos: 0
Cola vacía

--- Encolando 10, 20, 30, 40, 50 y 60 ---
Frente -> [10] [20] [30] [40] [50] [60] <- Fin
Frente (peek): 10
Elementos: 6

--- Desencolando dos elementos ---
Salió: 10
Salió: 20
Frente -> [30] [40] [50] [60] <- Fin
Elementos: 4

--- Sin límite de capacidad ---
Frente -> [30] [40] [50] [60] [70] [80] [90] <- Fin
Elementos: 7

--- Vaciando la cola ---
Salió: 30
Salió: 40
Salió: 50
Salió: 60
Salió: 70
Salió: 80
Salió: 90
¿Vacía? true
Elementos: 0
La cola está vacía
La cola está vacía
```



