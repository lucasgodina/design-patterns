El patrón Singleton (Instancia Única) garantiza que una clase tenga una sola instancia y proporciona un punto de acceso global a ella.

Es útil cuando:

1. Necesitas un único punto de control centralizado para alguna acción (como un gestor de configuración, un logger o un pool de conexiones).
2. Deseas que todas las partes de tu aplicación accedan a la misma y única instancia de un recurso.

El desafio de este patrón es asegurar que la instanciación esté controlada y que no se puedan crear objetos con el constructor normal.

En este ejemplo, vamos a implementar un Gestor de Configuración para cargar los ajustes iniciales del juego (volumen, resolución, dificultad, etc.). Sin el patrón Singleton, podríamos crear múltiples instancias de esta clase, lo cual es ineficiente y peligroso, ya que cada instancia podría tener valores de configuración diferentes, causando inconsistencias en el juego.

## Consideraciones

Este patrón es controversial y debe usarse con precaución, debido a las siguientes razones:

1. Introduce el Estado Global Encubierto (Global State): El Singleton actúa como una variable global, lo que puede llevar a dependencias ocultas y dificultar el seguimiento del estado de la aplicación.
2. Dificulta las Pruebas Unitarias - Imposibilidad de Simular (Mock) y Estado Residual: Al ser una instancia única, puede ser complicado aislar pruebas unitarias, ya que el estado del Singleton persiste entre pruebas.
3. Viola el Principio de Responsabilidad Única: El Singleton combina la responsabilidad de gestionar su propia instancia con la lógica de negocio, lo que puede llevar a clases con múltiples responsabilidades.
4. Dificultad con la Herencia: Los Singletons pueden complicar la herencia y la extensión de clases, ya que la lógica de instanciación está encapsulada dentro de la clase misma.
