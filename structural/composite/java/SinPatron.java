package structural.composite.java;

import java.util.ArrayList;
import java.util.List;

// Sin el patrón Composite, el código que calcula el tamaño de una carpeta debe usar lógica condicional
// para sumar el peso de sus contenidos, distinguendo si el contenido es un archivo simple o una subcarpeta.

// Clase de objetos individuales (Hoja)
class Archivo {
    private String nombre;
    private double tamaño; // en KB

    public Archivo(String nombre, double tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    // Método para obtener el tamaño del archivo individual
    public double getTamaño() {
        return tamaño;
    }
}

// Clase de contenedores (Compuesto)
// Esta clase no comparte la interfaz con Archivo y debe manejar la
// recursividad.
class Carpeta {
    private String nombre;
    // La lista debe ser de tipo 'Object' o 'List<?>', ya que contiene Archivos y
    // Carpetas
    private List<Object> contenidos = new ArrayList<>();

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Object componente) {
        contenidos.add(componente);
    }

    // Método para calcular el tamaño, diferente al de Archivo.
    public double calcularTamañoTotal() {
        double tamañoTotal = 0.0;

        System.out.println("Calculando tamaño de Carpeta: " + nombre);

        // Lógica condicional (el problema central)
        // Se debe verificar el tipo de cada elemento para saber qué método llamar.

        for (Object componente : contenidos) {
            if (componente instanceof Archivo) {
                // Llama al método específico de Archivo
                tamañoTotal += ((Archivo) componente).getTamaño();
            } else if (componente instanceof Carpeta) {
                // Si es una subcarpeta, llama al método recursivo
                tamañoTotal += ((Carpeta) componente).calcularTamañoTotal();
            }
            // Si hay un nuevo tipo de elemento, (por ejemplo, un enlace simbólico), se debe
            // modificar este 'if/else'
        }
        return tamañoTotal;
    }
}

// Clase principal para ejecutar el ejemplo sin el patrón
public class SinPatron {
    public static void main(String[] args) {

        // Archivos simples
        Archivo imagen = new Archivo("foto.jpg", 1500.0); // 1.5 MB
        Archivo documento = new Archivo("reporte.pdf", 500.0); // 0.5 MB

        // Carpeta raíz
        Carpeta proyecto = new Carpeta("Mi Proyecto");
        proyecto.agregar(imagen);
        proyecto.agregar(documento);

        // El cliente debe llamar al método específico 'calcularTamañoTotal' de Carpeta
        double tamañoTotal = proyecto.calcularTamañoTotal();
        System.out.println("\nTamaño total del proyecto: " + (tamañoTotal / 1000) + " MB");
    }
}
