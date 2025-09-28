package creational.factory.java;

// La principal desventaja de no usar el patrón Factory es que el código cliente está acoplado a las clases concretas.
// Si se agrega un nuevo tipo de enemigo, el código cliente debe modificarse para instanciar la nueva clase.
// Esto viola el principio de abierto/cerrado, ya que el código cliente no está cerrado para modificaciones.

// Interfaz Base (El producto)
interface Enemigo {
    void atacar();
}

// Clases Concretas (Productos Concretos)
class Ghost implements Enemigo {
    @Override
    public void atacar() {
        System.out.println("El fantasma ataca con un grito aterrador!");
    }
}

class Demon implements Enemigo {
    @Override
    public void atacar() {
        System.out.println("El demonio ataca con fuego infernal!");
    }
}

class SeaWitch implements Enemigo {
    @Override
    public void atacar() {
        System.out.println("La bruja del mar ataca con un hechizo acuático!");
    }
}

class KitavaCultist implements Enemigo {
    @Override
    public void atacar() {
        System.out.println("El cultista de Kitava ataca con una maldición oscura!");
    }
}

// Clase que tiene la lógica de creación
class GeneradorNivel {
    // Este método está fuertemente acoplado a las clases concretas Enemigo
    public Enemigo crearEnemigo(String tipo) {
        // Fuerte acoplamiento: se usa 'new' en clases concretas
        // Si se añade un nuevo tipo de enemigo (por ej. Lunaris Fanatics), este método
        // debe modificarse.
        if ("GHOST".equalsIgnoreCase(tipo)) {
            return new Ghost();
        } else if ("DEMON".equalsIgnoreCase(tipo)) {
            return new Demon();
        } else if ("SEAWITCH".equalsIgnoreCase(tipo)) {
            return new SeaWitch();
        } else if ("KITAVACULTIST".equalsIgnoreCase(tipo)) {
            return new KitavaCultist();
        } else {
            throw new IllegalArgumentException("Tipo de enemigo desconocido: " + tipo);
        }
    }
}

public class SinPatron {
    public static void main(String[] args) {
        GeneradorNivel generador = new GeneradorNivel();

        // El generador conoce y gestiona la creación de enemigos
        Enemigo enemigo1 = generador.crearEnemigo("GHOST");
        enemigo1.atacar();

        Enemigo enemigo2 = generador.crearEnemigo("KITAVACULTIST");
        enemigo2.atacar();

        // El problema es que la lógica de creación está expuesta
        // y requiere modificar la clase GeneradorNivel cada vez que cambian los
        // productos.

    }

}
