El patrón Singleton (Instancia Única) garantiza que una clase tenga una sola instancia y proporciona un punto de acceso global a ella.

Es útil cuando:

1. Necesitas un único punto de control centralizado para alguna acción (como un gestor de configuración, un logger o un pool de conexiones).
2. Deseas que todas las partes de tu aplicación accedan a la misma y única instancia de un recurso.

El desafio de este patrón es asegurar que la instanciación esté controlada y que no se puedan crear objetos con el constructor normal.

En este ejemplo, vamos a implementar un Gestor de Configuración para cargar los ajustes iniciales del juego (volumen, resolución, dificultad, etc.). Sin el patrón Singleton, podríamos crear múltiples instancias de esta clase, lo cual es ineficiente y peligroso, ya que cada instancia podría tener valores de configuración diferentes, causando inconsistencias en el juego.
