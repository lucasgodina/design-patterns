package structural.decorator.java;

// Sin el patrón Decorator, la única forma de añadir estas funcionalidades es a través de la herencia o código condicional en la clase base, lo que lleva a una explosión de clases o a un código frágil.
// Si usamos la herencia, tendríamos que crear una clase para cada combinación posible de funcionalidades, lo que no es escalable ni mantenible.

// Interfaz Base
interface Arma {
    double obtenerDaño();

    String obtenerDescripción();
}

// Clase Base
class ArcoBase implements Arma {
    @Override
    public double obtenerDaño() {
        return 15.0;
    }

    @Override
    public String obtenerDescripción() {
        return "Arco Básico";
    }
}

// Clases que añaden funcionalidad vía Herencia
// Se crea una clase para una sola funcionalidad
class ArcoConFuego extends ArcoBase {
    @Override
    public double obtenerDaño() {
        // Daño base (15.0) + daño por fuego (5.0)
        return super.obtenerDaño() + 5.0;
    }

    @Override
    public String obtenerDescripción() {
        // La descripción también debe ser modificada manualmente
        return super.obtenerDescripción() + " con Fuego";
    }
}

// Clase que añaden múltiples funcionalidades
class ArcoConFuegoConCriticoAumentado extends ArcoBase {
    // Es necesario replicar la lógica de Fuego y la lógica de Crítico Aumentado
    @Override
    public double obtenerDaño() {
        // Daño base (15.0) + daño por fuego (5.0) * 1.5 por crítico aumentado con 20%
        // de probabilidad random
        return (super.obtenerDaño() + 5.0) * (Math.random() < 0.2 ? 1.5 : 1.0);
    }

    @Override
    public String obtenerDescripción() {
        // La combinación de descripciones se vuelve compleja y propensa a errores
        return super.obtenerDescripción() + " + Fuego + Crítico Aumentado";
    }
}

// Clase principal para ejecutar el ejemplo
public class SinPatron {
    public static void main(String[] args) {
        // Uso del rifle base
        Arma arcoBase = new ArcoBase();
        System.out.println("1. " + arcoBase.obtenerDescripción() + " - Daño: " + arcoBase.obtenerDaño());

        // Uso del arco con fuego
        Arma arcoConFuego = new ArcoConFuego();
        System.out.println("2. " + arcoConFuego.obtenerDescripción() + " - Daño: " + arcoConFuego.obtenerDaño());

        // Uso del arco con fuego y crítico aumentado
        Arma arcoConFuegoConCriticoAumentado = new ArcoConFuegoConCriticoAumentado();
        System.out.println("3. " + arcoConFuegoConCriticoAumentado.obtenerDescripción() + " - Daño: "
                + arcoConFuegoConCriticoAumentado.obtenerDaño());
    }

}
