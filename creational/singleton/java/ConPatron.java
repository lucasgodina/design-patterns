package creational.singleton.java;

// Ventajas del patrón Singleton:

// 1. Control de acceso a la instancia única.
// 2. Ahorro de memoria al evitar múltiples instancias.
// 3. Facilita la gestión de recursos compartidos.
// 4. Proporciona un punto de acceso global a la instancia.

// La clase que debería ser única
class GestorConfiguracion {
    // Instancia estática privada: "lazy loading" (se crea solo cuando se necesita)
    private static GestorConfiguracion instanciaUnica;

    private String configuracionInicial;

    // Constructor privado: Impide la creación de nuevas instancias con 'new'
    private GestorConfiguracion() {
        // Simulación de carga de configuración pesada
        this.configuracionInicial = "Cargando configuración... (Volumen: 50, Resolucion: 1080p)";
        System.out.println(this.configuracionInicial + " -- INSTANCIA CREADA");
    }

    // Método estático público: Proporciona el punto de acceso global
    public static GestorConfiguracion obtenerInstancia() {
        // Lógica de creación: solo si la instancia aún no existe
        if (instanciaUnica == null) {
            instanciaUnica = new GestorConfiguracion();
        }
        return instanciaUnica;
    }

    // Métodos de negocio
    public void mostrarConfiguracion() {
        System.out.println("Configuración actual: " + this.configuracionInicial);
    }

    public void cambiarVolumen(int nuevoVolumen) {
        // Note que el cambio se aplica a la única instancia
        this.configuracionInicial = "Volumen: " + nuevoVolumen + ", Resolucion: 1080p";
        System.out.println("VOLUMEN CAMBIADO A: " + nuevoVolumen);
    }
}

// Clase principal para ejecutar el ejemplo con el patrón Singleton
public class ConPatron {
    public static void main(String[] args) {
        // Módulo de Audio accede a la única instancia
        System.out.println("Módulo de Audio solicita la configuración:");
        GestorConfiguracion configAudio = GestorConfiguracion.obtenerInstancia();
        configAudio.cambiarVolumen(80);

        System.out.println("\n---");

        // Módulo de Gráficos accede a la misma instancia
        System.out.println("Módulo de Gráficos solicita la configuración:");
        GestorConfiguracion configGraficos = GestorConfiguracion.obtenerInstancia();

        // El constructor SOLO se llamó una vez.
        // Las dos variables hacen referencia al mismo objeto.

        System.out.println("\nEstado de la única instancia:");
        System.out.println("Estado visto por Audio: ");
        configAudio.mostrarConfiguracion(); // Muestra Volumen: 80

        System.out.println("Estado visto por Gráficos: ");
        configGraficos.mostrarConfiguracion(); // Muestra Volumen: 80
    }
}
