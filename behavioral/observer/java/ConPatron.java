package behavioral.observer.java;

// Ventajas de aplicar este patrón:
// 1. Desacoplamiento: El sujeto (Player) no necesita conocer los detalles de sus observadores (HealthBar y HealthCounter). Solo sabe que deben ser notificados cuando su estado cambia.
// 2. Extensibilidad: Se pueden añadir nuevos observadores sin modificar la clase Player. Por ejemplo, podríamos agregar un sistema de log o una animación que también se actualice cuando el jugador recibe daño.
// 3. Flexibilidad: Los observadores pueden ser añadidos o eliminados en tiempo de ejecución, lo que permite una mayor adaptabilidad del sistema.
// 4. Coherencia del Estado: Todos los observadores se actualizan automáticamente cuando el estado del sujeto cambia, asegurando que la interfaz siempre refleje el estado actual del jugador.

import java.util.ArrayList;
import java.util.List;

// Interfaz del Observer
// Define el contrato para los objetos que quieren ser notificados
interface IObserver {
    void update(int health);
}

// Interfaz del Subject
// Define la API para registrar y eliminar observadores
interface ISubject {
    void registerObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();
}

// Clase que representa al jugador (Subject)
class Player implements ISubject {
    private int health;
    private List<IObserver> observers;

    public Player() {
        this.health = 100;
        this.observers = new ArrayList<>();
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println("El jugador recibió " + damage + " puntos de daño. Vida actual: " + this.health);
        notifyObservers();
    }

    // Implementación de la interfaz ISubject
    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(this.health);
        }
    }
}

// Clases de los Observadores Concretos
// Implementan la interfaz IObserver y se actualizan a sí mismos
class HealthBar implements IObserver {
    @Override
    public void update(int health) {
        System.out.println("Barra de vida actualizada: " + health + " puntos de vida.");
    }
}

class HealthCounter implements IObserver {
    @Override
    public void update(int health) {
        System.out.println("Contador de vida actualizado: " + health + " puntos de vida.");
    }
}

// Clase principal para ejecutar el ejemplo con patrón Observer
public class ConPatron {
    public static void main(String[] args) {

        // 1. Crear el sujeto y los observadores
        Player player = new Player();
        HealthBar healthBar = new HealthBar();
        HealthCounter healthCounter = new HealthCounter();

        // 2. Registrar los observadores en el sujeto
        player.registerObserver(healthBar);
        player.registerObserver(healthCounter);

        // 3. El jugador cambia de estado, y los observadores se actualizan
        // automáticamente
        player.takeDamage(20);
        System.out.println("-----------------------");
        player.takeDamage(50);

        // 4. Un observador puede ser eliminado dinámicamente
        System.out.println("-----------------------");
        System.out.println("Eliminando HealthBar .");
        player.removeObserver(healthBar);
        player.takeDamage(40); // Esto debería reducir la vida a 0
    }
}
