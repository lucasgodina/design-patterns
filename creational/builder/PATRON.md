EL patrón Builder (Constructor) se usa para separar la construcción de un objeto complejo de su representación, de modo que el mismo proceso de construcción pueda crear diferentes representaciones.

Es ideal cuando:

1. Un objeto tiene muchos atributos opcionales y el constructor se vuelve inmanejable.
2. Necesitas construir objetos en varias fases o pasos.
3. Quieres evitar el "telescoping constructor" (tener muchos constructores con diferente número de parámetros).

En este ejemplo, construiremos un personaje de un juego de rol (RPG). El personaje tiene muchos atributos, algunos obligatorios y muchos opcionales (montura, armadura, arma secundaria, habilidades especiales, etc.)
