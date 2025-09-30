package structural.decorator.java;

// Ventajas del patrón Decorator:
// 1. Flexibilidad: Puedes combinar múltiples decoradores en tiempo de ejecución para crear diferentes
//    combinaciones de funcionalidades sin necesidad de crear una clase para cada combinación.
// 2. Mantenibilidad: Cada decorador se encarga de una única responsabilidad, lo que facilita la comprensión y el mantenimiento del código.
// 3. Reutilización: Los decoradores pueden ser reutilizados en diferentes contextos sin necesidad de duplicar código.
// 4. Adición dinámica: Puedes añadir o quitar funcionalidades en tiempo de ejecución, lo que no es posible con la herencia estática.

// Interfaz Componente
// La interfaz que el Arma base y todos los decoradores deben implementar
interface Arma {
    double obtenerDaño();

    String obtenerDescripcion();
}

// Componente Concreto
// El objeto base que se va a decorar
class ArcoBase implements Arma {
    @Override
    public double obtenerDaño() {
        return 15.0;
    }

    @Override
    public String obtenerDescripcion() {
        return "Arco Básico";
    }
}

// Clase Decorador Abstracto
// Mantiene una referencia al Componente y delega la llamada a él.
abstract class DecoradorArma implements Arma {
    protected Arma armaDecorada; // Referencia al objeto envuelto

    public DecoradorArma(Arma armaDecorada) {
        this.armaDecorada = armaDecorada;
    }

    // Delega los métodos de la interfaz
    @Override
    public double obtenerDaño() {
        return armaDecorada.obtenerDaño();
    }

    @Override
    public String obtenerDescripcion() {
        return armaDecorada.obtenerDescripcion();
    }
}

// Decoradores Concretos
// Añaden funcionalidad sin modificar la estructura base
class DecoradorFuego extends DecoradorArma {
    public DecoradorFuego(Arma armaDecorada) {
        super(armaDecorada);
    }

    // Añade 5.0 de daño al resultado del objeto envuelto
    @Override
    public double obtenerDaño() {
        return super.obtenerDaño() + 5.0;
    }

    // Añade " + Fuego" a la descripción del objeto envuelto
    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + Fuego";
    }
}

class DecoradorCriticoAumentado extends DecoradorArma {
    public DecoradorCriticoAumentado(Arma armaDecorada) {
        super(armaDecorada);
    }

    // Aplica un multiplicador de 1.5 al daño con una probabilidad del 20%
    @Override
    public double obtenerDaño() {
        return super.obtenerDaño() * (Math.random() < 0.2 ? 1.5 : 1.0);
    }

    // Añade " + Crítico Aumentado" a la descripción del objeto envuelto
    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + Crítico Aumentado";
    }
}

// Clase principal para ejecutar el ejemplo
public class ConPatron {
    public static void main(String[] args) {
        // Creación de un Arco Base
        Arma arcoBase = new ArcoBase();
        System.out.println("1. " + arcoBase.obtenerDescripcion() + " - Daño: " + arcoBase.obtenerDaño());

        System.out.println("-----------------------------------");

        // Decorar con Fuego
        // ArcoConFuego envuelve a ArcoBase
        Arma arcoConFuego = new DecoradorFuego(arcoBase);
        System.out.println("2. " + arcoConFuego.obtenerDescripcion() + " - Daño: " + arcoConFuego.obtenerDaño());

        System.out.println("-----------------------------------");

        // Decoración multiple: Fuego + Crítico Aumentado
        // ArcoConFuegoConCriticoAumentado envuelve a ArcoConFuego, que a su vez
        // envuelve a ArcoBase
        Arma arcoConFuegoConCriticoAumentado = new DecoradorCriticoAumentado(arcoConFuego);
        System.out.println("3. " + arcoConFuegoConCriticoAumentado.obtenerDescripcion() + " - Daño: "
                + arcoConFuegoConCriticoAumentado.obtenerDaño());

        System.out.println("-----------------------------------");

        // Nueva combinación dinámica: Solo Crítico Aumentado
        // No se necesita crear una nueva clase, simplemente envolver el ArcoBase
        Arma arcoConCriticoAumentado = new DecoradorCriticoAumentado(arcoBase);
        System.out.println("4. " + arcoConCriticoAumentado.obtenerDescripcion() + " - Daño: "
                + arcoConCriticoAumentado.obtenerDaño());
    }
}
