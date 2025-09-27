El patrón Strategy te permite definir una familia de algoritmos, encapsular cada uno de ellos y hacerlos intercambiables.
Permite que el cliente (el código que usa los algoritmos) escoja la estrategia que necesita en tiempo de ejecución, sin que el cliente tenga que conocer la implementación interna de esa estrategia.

En esencia, el patrón Strategy:

1. Define una interfaz común para todos los algoritmos (la Estrategia).
2. Encapsula cada algoritmo en una clase separada (Estrategias Concretas).
3. Permite que el objeto que utiliza el algoritmo (el Contexto) delegue la ejecución a la Estrategia que tiene asignada.

El resultado es un código más limpio donde el Contexto no tiene que preocuparse por la lógica adicional (if/else o switch) para selecciona un algoritmo.

## Ejemplo

Imagina una aplicación que calcula el coste de envío. El coste varía según la empresa de transporte que elija (por ejemplo, FedEx, UPS o Correo Local), y cada empresa utiliza un algoritmo de cálculo diferente.
