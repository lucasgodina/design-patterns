package creational.factory.java;

// Ventajas de usar el patrón Factory:
// 1. Desacoplamiento: El código cliente no está acoplado a las clases concretas.
// 2. Extensibilidad: Se pueden agregar nuevos tipos de enemigos sin modificar el código cliente.
// 3. Mantenimiento: La lógica de creación está centralizada en una sola clase.
// 4. Principio de abierto/cerrado: El código cliente está cerrado para modificaciones.

// Interfaz Base (Producto)
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

// Clase Creadora (Factory Method)
// Esta clase centraliza la lógica de creación.
class FactoriaEnemigo {

    // El método de fábrica es el responsable de la instanciación.
    public Enemigo crearEnemigo(String tipo) {
        // La lógica condicional está ahora confinada en la Fábrica.
        // El cliente (GeneradorNivel) ya no la necesita.
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

// Cliente (Contexto o Generador)
// Este cliente ahora usa la Fábrica y está desacoplada de las clases concretas.
class GeneradorNivel {
    private FactoriaEnemigo factoria = new FactoriaEnemigo();

    // El generador ahora delega la creación a la fábrica.
    public Enemigo generarEnemigo(String tipo) {
        System.out.println("El nivel ha solicitado un enemigo..");
        return factoria.crearEnemigo(tipo);
    }
}

// Clase principal para ejecutar el ejemplo
public class ConPatron {
    public static void main(String[] args) {
        GeneradorNivel generador = new GeneradorNivel();

        // El Generador solicita un enemigo al tipo.
        // La Factoria decide qué clase concreta instanciar.

        Enemigo enemigo1 = generador.generarEnemigo("GHOST");
        enemigo1.atacar();

        Enemigo enemigo2 = generador.generarEnemigo("KITAVACULTIST");
        enemigo2.atacar();

        // Ventaja: Si se añade un nuevo enemigo, solo se modifica la FactoriaEnemigo.
        // La clase GeneradorNivel NO necesita ser modificada.
    }

}
