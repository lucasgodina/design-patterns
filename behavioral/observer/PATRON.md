El patrón Observer define una dependencia uno a muchos entre objetos. Cuando el estado de un objeto (Subject) cambia, todos sus dependientes (Observers) son notificados y actualizados automáticamente.
Este patrón es ideal para situaciones en las que un cambio en un objeto necesita notificar a otros objetos sin que el objeto principal necesite saber quiénes son esos dependientes.

En este ejemplo vamos a implementar un sistema de un juego en el cual un personaje (Player) tiene puntos de vida. Cuando el personaje recibe daño, dos elementos de la interfaz deben actualizarse: una barra de vida (HealthBar) y un contador de vida (HealthCounter).
