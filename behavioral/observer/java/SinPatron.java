package behavioral.observer.java;

// Sin el patrón Observer, la clase Player está directamente acoplada a las clases HealthBar y HealthCounter.
// Cada vez que el jugador pierde vida, debe llamar directamente a los métodos de actualización de cada uno de esos elementos.

// Clase que representa al jugador (Subject)
class Player {
    private int health;
    private HealthBar healthBar;
    private HealthCounter healthCounter;

    public Player(int health, HealthBar healthBar, HealthCounter healthCounter) {
        this.health = health;
        this.healthBar = healthBar;
        this.healthCounter = healthCounter;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println("El jugador ha recibido " + damage + " puntos de daño. Vida actual: " + this.health);

        // Notificación directa a los dependientes
        this.healthBar.update(this.health);
        this.healthCounter.update(this.health);
    }
}

// Clases dependientes (Observers)
class HealthBar {
    public void update(int health) {
        System.out.println("Barra de vida actualizada: " + health + " puntos de vida.");
    }
}

class HealthCounter {
    public void update(int health) {
        System.out.println("Contador de vida actualizado: " + health + " puntos de vida.");
    }
}

// Clase principal para ejecutar el ejemplo sin patrón Observer
public class SinPatron {
    public static void main(String[] args) {
        HealthBar healthBar = new HealthBar();
        HealthCounter healthCounter = new HealthCounter();
        Player player = new Player(100, healthBar, healthCounter);

        // El jugador recibe daño y notifica directamente a los elementos de la interfaz
        player.takeDamage(20);
        player.takeDamage(50);
        player.takeDamage(40); // Esto debería reducir la vida a 0
    }
}