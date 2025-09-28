package creational.singleton.java;

// El problema principal sin el patrón es que múltiples instancias de una clase
// que debería ser única pueden ser creadas, llevando a inconsistencias y
// problemas de sincronización en la configuración compartida.

// La clase que deberia ser única
class GestorConfiguracion {
    private String configuracionInicial;

    // Constructor público que permite crear múltiples instancias
    public GestorConfiguracion() {
        // Simulación de carga de configuración pesada
        this.configuracionInicial = "Cargando configuración... (Volumen: 50, Resolucion: 1080p)";
        System.out.println(this.configuracionInicial + " -- INSTANCIA CREADA");
    }

    public void mostrarConfiguracion() {
        System.out.println("Configuración actual: " + this.configuracionInicial);
    }

    public void cambiarVolumen(int nuevoVolumen) {
        this.configuracionInicial = "Volumen: " + nuevoVolumen + ", Resolucion: 1080p";
        System.out.println("VOLUMEN CAMBIADO A: " + nuevoVolumen);
    }
}

// Clase principal para ejecutal el ejemplo sin el patrón
public class SinPatron {
    public static void main(String[] args) {
        // Un módulo del juego crea una instancia
        System.out.println("Módulo de Audio crea su GestorConfiguracion:");
        GestorConfiguracion configAudio = new GestorConfiguracion();
        configAudio.cambiarVolumen(80);

        System.out.println("\n---");

        // Otro módulo del juego crea otra instancia (PROBLEMA!)
        System.out.println("Módulo de Gráficos crea su GestorConfiguracion:");
        GestorConfiguracion configGraficos = new GestorConfiguracion();

        // Al final, tenemos dos objetos distintos, y el cambio de volumen
        // hecho en 'configAudio' no se refleja en 'configGraficos'.
        System.out.println("\nEstado de las instancias:");
        System.out.println("Estado de Audio: ");
        configAudio.mostrarConfiguracion(); // Muestra Volumen: 80

        System.out.println("Estado de Gráficos: ");
        configGraficos.mostrarConfiguracion(); // Muestra Volumen: 50
    }

}