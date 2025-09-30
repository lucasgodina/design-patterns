package structural.composite.java;

import java.util.ArrayList;
import java.util.List;

// Ventajas de usar el patrón Composite:
// 1. Simplicidad: Permite tratar objetos individuales y compuestos de manera uniforme.
// 2. Flexibilidad: Facilita la adición de nuevos tipos de componentes sin afectarar el código cliente.
// 3. Estructura jerárquica: Representa estructuras de árbol de manera natural.

// Interfaz Componente
// Define la interfaz común para Archivos y Carpetas
interface ComponenteSistemaArchivos {
    double obtenerTamaño(); // El método unificado
}

// Clase de objetos individuales (Hoja)
class Archivo implements ComponenteSistemaArchivos {
    private String nombre;
    private double tamaño; // en KB

    public Archivo(String nombre, double tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    // El metodo de la interfaz
    @Override
    public double obtenerTamaño() {
        System.out.println(" -- Sumando tamaño del Archivo: " + nombre);
        return tamaño;
    }
}

// Clase de contenedores (Compuesto)
class Carpeta implements ComponenteSistemaArchivos {
    private String nombre;
    // Ahora la lista es de tipo ComponenteSistemaArchivos (uniforme)
    private List<ComponenteSistemaArchivos> contenidos = new ArrayList<>();

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    // El método de gestión de la jerarquía es solo para el Compuesto
    public void agregar(ComponenteSistemaArchivos componente) {
        contenidos.add(componente);
    }

    // El método de la interfaz (ahora sin if/else ni instanceof)
    @Override
    public double obtenerTamaño() {
        double tamañoTotal = 0.0;

        System.out.println("Calculando tamaño de la Carpeta: " + nombre);

        // Lógica limpia y uniforme:
        // Simplemente se llama al método 'obtenerTamaño()' en todos los componentes
        for (ComponenteSistemaArchivos componente : contenidos) {
            // El componente sabe cómo calcular su tamaño (recursivamente o directamente)
            tamañoTotal += componente.obtenerTamaño();
        }
        return tamañoTotal;
    }
}

// Clase principal para ejecutar el ejemplo
public class ConPatron {
    public static void main(String[] args) {
        // Archivos simples
        Archivo imagen = new Archivo("foto.jpg", 1500.0);
        Archivo documento = new Archivo("reporte.pdf", 500.0);

        // Carpeta 1: Documentos
        Carpeta documentos = new Carpeta("Mis Documentos");
        documentos.agregar(documento);

        // Carpeta Raíz: Proyecto
        Carpeta proyecto = new Carpeta("Mi Proyecto");
        proyecto.agregar(imagen); // Agrega un Archivo
        proyecto.agregar(documentos); // Agrega una Carpeta

        // El cliente trata a todos de forma uniforme:
        // Llama a 'obtenerTamaño()' sin saber si es un Archivo o una Carpeta.
        double tamañoTotal = proyecto.obtenerTamaño();
        System.out.println("\n------------------------------");
        System.out.println("Tamaño total del proyecto: " + (tamañoTotal / 1000) + " MB");
    }
}
