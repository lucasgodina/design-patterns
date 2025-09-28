El patrón Factory Method (Método de Fábrica) defina una interfaz para crear un objeto, pero permite que las subclases decidan qué clase instanciar. Esto delega la responsabilidad de la instanciación de una clase a otra.

Es útil cuando:

1. Una clase no puede anticipar la clase de objetos que debe crear.
2. Una clase quiere que sus subclases especifiquen los objetos que se van a crear.

El patrón Factory Method promueve el desacoplamiento: la clase que necesita un objeto (el cliente) no necesita saber cómo se crea ese objeto, solo necesita la interfaz del Factory.

En este ejemplo, crearemos un sistema para un juego donde los enemigos son generados en diferentes niveles. Queremos crear distintos tipos de enemigos, por ej. Ghosts, Demons, Sea Witches, Cultists of Kitava, etc.
