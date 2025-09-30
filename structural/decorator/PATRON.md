El patrón Decorator (Decorador) te permite añadir nuevas funcionalidades o responsabilidades a un objeto dinámicamente sin modificar su código base. Envuelve el objeto original (el componente) con una o varias capas de "decoradores".

Es una alternativa flexible a la herencia para extender la funcionalidad. En lugar de heredar de una clase para añadir un comportamiento, usas el Decorator para envolver el objeto en tiempo de ejecución.

En este ejemplo, vamos a implementar un sistema de juego donde tienes un arma base (ArmaBase) y quieres crear variaciones que añaden daño elemental (fuego, hielo, etc.) o efectos (CríticoAumentado, Veneno, Aturdimiento, etc.).
