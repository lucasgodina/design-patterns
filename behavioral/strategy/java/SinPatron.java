package behavioral.strategy.java;

// El principal problema de este enfoque es que la clase CalculadoraEnvio
// está fuertemente acoplada a las diferentes estrategias de cálculo de costos.
// Cada vez que se añade un nuevo transportista, hay que modificar esta clase,
// lo que viola el Principio Abierto/Cerrado (OCP) de SOLID.

// La clase que contiene el contexto y toda la lógica condicional
class CalculadoraEnvio {
    public static final String FEDEX = "FedEx";
    public static final String UPS = "UPS";
    public static final String LOCAL = "Local";

    // Este método contiene la lógica condicional (el problema a resolver)
    public double calcularCosto(String tipoEnvio, double peso, double distancia) {
        double costoFinal = 0.0;

        // Fuerte acoplamiento y violación del Principio Abierto/Cerrado (OCP).
        // Si se añade un nuevo transportista, hay que modificar esta clase.
        if (tipoEnvio.equals(FEDEX)) {
            // Algoritmo de FedEx
            costoFinal = 5.0 + (peso * distancia / 10);
            System.out.println("Calculando costo con FedEx..");
        } else if (tipoEnvio.equals(UPS)) {
            // Algoritmo de UPS
            costoFinal = 10.0 + (peso * 0.5);
            System.out.println("Calculando costo con UPS..");
        } else if (tipoEnvio.equals(LOCAL)) {
            // Algoritmo de una empresa local
            costoFinal = 3.5;
            System.out.println("Calculando costo con Correo Local..");
        } else {
            throw new IllegalArgumentException("Tipo de envío no soportado: " + tipoEnvio);
        }

        return costoFinal;
    }
}

public class SinPatron {
    public static void main(String[] args) {
        CalculadoraEnvio calculadora = new CalculadoraEnvio();

        double peso = 2.5; // en kg
        double distancia = 50.0; // en km

        // Calculando con diferentes tipos de envio
        double costoFedex = calculadora.calcularCosto(CalculadoraEnvio.FEDEX, peso, distancia);
        System.out.println("Costo FedEx: $" + String.format("%.2f", costoFedex));

        double costoUPS = calculadora.calcularCosto(CalculadoraEnvio.UPS, peso, distancia);
        System.out.println("Costo UPS: $" + String.format("%.2f", costoUPS));

        double costoLocal = calculadora.calcularCosto(CalculadoraEnvio.LOCAL, peso, distancia);
        System.out.println("Costo Correo Local: $" + String.format("%.2f", costoLocal));
    }
}