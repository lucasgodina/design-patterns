package behavioral.strategy.java;

// Ventajas del patrón Strategy:
// 1. Desacoplamiento: Separa las estrategias de cálculo de costos de la
//    clase que las utiliza, facilitando la adición de nuevas estrategias sin
//    modificar el código existente.
// 2. Mantenibilidad: Cada estrategia está encapsulada en su propia clase,
//    lo que hace que el código sea más limpio y fácil de mantener.
// 3. Flexibilidad: Permite cambiar la estrategia en tiempo de ejecución,
//    adaptándose a diferentes condiciones o requisitos.
// 4. Cumplimiento del Principio Abierto/Cerrado (OCP):
//    La clase que utiliza las estrategias no necesita ser modificada
//    para soportar nuevas estrategias, cumpliendo así con este principio de SOLID.

// Interfaz de Estrategia
// Define un contrato común para todos los algoritmos de cálculo.
interface EstrategiaEnvio {
    double calcularCosto(double peso, double distancia);
}

// Estrategias concretas
// Implementan los diferentes algoritmos.
class EstrategiaFedEx implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double peso, double distancia) {
        // Algoritmo de FedEx: Costo base + (peso * distancia / 10)
        System.out.println("Calculando costo con FedEx..");
        return 5.0 + (peso * distancia / 10);
    }
}

class EstrategiaUPS implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double peso, double distancia) {
        // Algoritmo de UPS: Costo base + (peso * 0.5)
        System.out.println("Calculando costo con UPS..");
        return 10.0 + (peso * 0.5);
    }
}

class EstrategiaCorreoLocal implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double peso, double distancia) {
        // Algoritmo de una empresa local: Tarifa plana
        System.out.println("Calculando costo con Correo Local..");
        return 3.5;
    }
}

// Contexto
// Utiliza la interfaz de Estrategia para delegar la ejecución.
// Ahora NO tiene la lógica condicional. (if/else o switch)
class CalculadoraEnvio {
    private EstrategiaEnvio estrategia;

    // El cliente define qué estrategia usar a través de este método.
    public void establecerEstrategia(EstrategiaEnvio estrategia) {
        this.estrategia = estrategia;
    }

    public double ejecutarCalculo(double peso, double distancia) {
        if (estrategia == null) {
            throw new IllegalStateException("Estrategia no establecida");
        }
        // Delega la ejecución a la estrategia actual
        return estrategia.calcularCosto(peso, distancia);
    }
}

// Clase principal para ejecutar el ejemplo
public class ConPatron {
    public static void main(String[] args) {
        CalculadoraEnvio calculadora = new CalculadoraEnvio();

        double peso = 2.5; // en kg
        double distancia = 50.0; // en km

        // Uso de EstrategiaFedEx
        calculadora.establecerEstrategia(new EstrategiaFedEx());
        double costoFedex = calculadora.ejecutarCalculo(peso, distancia);
        System.out.println("Costo FedEx: $" + String.format("%.2f", costoFedex));

        System.out.println("--------------------------------");

        // Cambio de Estrategia en tiempo de ejecución
        calculadora.establecerEstrategia(new EstrategiaUPS());
        double costoUPS = calculadora.ejecutarCalculo(peso, distancia);
        System.out.println("Costo UPS: $" + String.format("%.2f", costoUPS));

        System.out.println("--------------------------------");

        // Añadir una nueva estrategia Correo Local sin modificar CalculadoraEnvio
        calculadora.establecerEstrategia(new EstrategiaCorreoLocal());
        double costoLocal = calculadora.ejecutarCalculo(peso, distancia);
        System.out.println("Costo Correo Local: $" + String.format("%.2f", costoLocal));
    }
}
