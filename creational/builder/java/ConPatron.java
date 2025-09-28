package creational.builder.java;

// Ventajas del patrón Builder:
// 1. Mejora la legibilidad del código al evitar constructores con muchos parámetros.
// 2. Facilita la creación de objetos complejos paso a paso.
// 3. Permite la creación de diferentes representaciones del mismo objeto.
// 4. Cumple con el principio de abierto/cerrado (OCP) al permitir añadir nuevos atributos sin modificar el constructor existente.
// 5. Facilita la validación de los atributos antes de construir el objeto final.

// Clase del producto complejo (Character)
// Ahora solo tiene un constructor privado que acepta el Builder.
class Personaje {
    // Atributos obligatorios
    private final String nombre;
    private final String clase; // Guerrero, Mago, Arquero

    // Atributos opcionales
    private final String armadura;
    private final String armaPrincipal;
    private final String armaSecundaria;
    private final String montura;
    private final String habilidadEspecial;
    private final int puntosFuerza;
    // ... y muchos más

    // Constructor privado: solo el Builder puede llamarlo
    private Personaje(PersonajeBuilder builder) {
        this.nombre = builder.nombre;
        this.clase = builder.clase;
        this.armadura = builder.armadura;
        this.armaPrincipal = builder.armaPrincipal;
        this.armaSecundaria = builder.armaSecundaria;
        this.montura = builder.montura;
        this.habilidadEspecial = builder.habilidadEspecial;
        this.puntosFuerza = builder.puntosFuerza;
        // ...
    }

    @Override
    public String toString() {
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

    // Clase Builder (Constructor Estático Anidado)
    public static class PersonajeBuilder {
        // Atributos obligatorios del Personaje (repetidos en el Builder)
        private final String nombre;
        private final String clase;

        // Atributos opcionales (con valores por defecto si es necesario)
        private String armadura = null;
        private String armaPrincipal = null;
        private String armaSecundaria = null;
        private String montura = null;
        private String habilidadEspecial = null;
        private int puntosFuerza = 10; // Valor por defecto

        // Constructor del Builder: solo acepta los parámetros obligatorios
        public PersonajeBuilder(String nombre, String clase) {
            this.nombre = nombre;
            this.clase = clase;
        }

        // Métodos de construcción (setters) para los atributos opcionales
        public PersonajeBuilder conArmadura(String armadura) {
            this.armadura = armadura;
            return this; // Retorna 'this' para encadenamiento
        }

        public PersonajeBuilder conArmaPrincipal(String armaPrincipal) {
            this.armaPrincipal = armaPrincipal;
            return this;
        }

        public PersonajeBuilder conArmaSecundaria(String armaSecundaria) {
            this.armaSecundaria = armaSecundaria;
            return this;
        }

        public PersonajeBuilder conMontura(String montura) {
            this.montura = montura;
            return this;
        }

        public PersonajeBuilder conHabilidadEspecial(String habilidadEspecial) {
            this.habilidadEspecial = habilidadEspecial;
            return this;
        }

        public PersonajeBuilder conPuntosFuerza(int puntosFuerza) {
            this.puntosFuerza = puntosFuerza;
            return this;
        }

        // Método final: construye y devuelve el objeto Personaje
        public Personaje construir() {
            return new Personaje(this);
        }
    }
}

// Clase principal para ejecutar el ejemplo
public class ConPatron {
    public static void main(String[] args) {
        // Construcción de un Arquero Completo (legible y secuencial)
        Personaje arqueroCompleto = new Personaje.PersonajeBuilder("Arkherion", "Arquero")
                .conArmadura("Hyrri's Ire")
                .conArmaPrincipal("Tri-Elemental Bow")
                .conArmaSecundaria("Dual Dagger")
                .conMontura("Caballo")
                .conHabilidadEspecial("Elemental Hit of the Spectrum")
                .conPuntosFuerza(15)
                .construir(); // Finaliza la construcción

        System.out.println(arqueroCompleto);

        // Construcción de un Mago Básico (sin pasar 'null' innecesarios)
        // Sólo se definen los parámetros obligatorios y el arma principal
        Personaje magoBasico = new Personaje.PersonajeBuilder("Arkhie", "Mago")
                .conArmaPrincipal("Cane of Unravelling")
                .construir(); // Finaliza la construcción

        System.out.println(magoBasico);
    }

}
