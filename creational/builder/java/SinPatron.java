package creational.builder.java;

// El principal problema de este enfoque es que el constructor de la clase Personaje
// tiene demasiados parámetros, muchos de los cuales son opcionales. Esto hace que
// sea difícil de leer y mantener. Además, si se quieren añadir más atributos
// opcionales en el futuro, habría que modificar el constructor, lo que viola el
// Principio Abierto/Cerrado (OCP) de SOLID.

// Clase del producto complejo (Character)
class Personaje {
    // Atributos obligatorios
    private String nombre;
    private String clase; // Guerrero, Mago, Arquero

    // Atributos opcionales (muchos de ellos pueden ser null)
    private String armadura;
    private String armaPrincipal;
    private String armaSecundaria;
    private String montura;
    private String habilidadEspecial;
    private int puntosFuerza;
    // ... y muchos más

    // Constructor con demasiados parámetros (el problema del telescoping
    // constructor)
    public Personaje(String nombre, String clase, String armadura, String armaPrincipal, String armaSecundaria,
            String montura, String habilidadEspecial, int puntosFuerza /* , ... */) {
        // Obligatorios
        this.nombre = nombre;
        this.clase = clase;

        // Opcionales
        this.armadura = armadura;
        this.armaPrincipal = armaPrincipal;
        this.armaSecundaria = armaSecundaria;
        this.montura = montura;
        this.habilidadEspecial = habilidadEspecial;
        this.puntosFuerza = puntosFuerza;
        // ...
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public String getClase() {
        return clase;
    }

    public String getArmadura() {
        return armadura;
    }

    public String getArmaPrincipal() {
        return armaPrincipal;
    }

    public String getArmaSecundaria() {
        return armaSecundaria;
    }

    public String getMontura() {
        return montura;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public int getPuntosFuerza() {
        return puntosFuerza;
    }

    @Override
    public String toString() {
        // Muestra la representación del personaje
        return "--- Personaje Creado ---\n" +
                "Nombre: " + nombre + "\n" +
                "Clase: " + clase + "\n" +
                "Armadura: " + (armadura != null ? armadura : "Ninguna") + "\n" +
                "Arma Principal: " + (armaPrincipal != null ? armaPrincipal : "Ninguna") + "\n" +
                "Arma Secundaria: " + (armaSecundaria != null ? armaSecundaria : "Ninguna") + "\n" +
                "Montura: " + (montura != null ? montura : "Ninguna") + "\n" +
                "Habilidad Especial: " + (habilidadEspecial != null ? habilidadEspecial : "Ninguna") + "\n" +
                "Puntos de Fuerza: " + puntosFuerza + "\n";
    }

    // Clase principal para ejecutar el ejemplo sin el patrón
    public class SinPatron {
        public static void main(String[] args) {
            // Problema 1: Dificultad para saber qué parámetro es cuál (legibilidad baja)
            // Problema 2: Hay que pasar 'null' para los parámetros opcionales que no se
            // usan
            Personaje arqueroCompleto = new Personaje(
                    "Arkherion",
                    "Arquero",
                    "Hyrri's Ire",
                    "Tri-Elemental Bow",
                    "Dual Dagger",
                    "Caballo",
                    "Elemental Hit of the Spectrum",
                    15);
            System.out.println(arqueroCompleto);

            // Problema 3: Si solo queremos un mago básico, es aún peor.
            // Hay que pasar muchos 'null' para llenar los huecos.
            Personaje magoBasico = new Personaje(
                    "Arkhie",
                    "Mago",
                    null, // armadura
                    "Cane of Unravelling",
                    null, // armaSecundaria
                    null, // montura
                    "Soulrend",
                    5 // puntosFuerza
            );
            System.out.println(magoBasico);
        }
    }
}
