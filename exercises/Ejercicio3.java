public class Ejercicio3 {

    public static void main(String[] args) {
        Computadora computadora = new Computadora();

        computadora.establecerProcesador("Intel i7");
        computadora.establecerMemoria("16GB RAM");
        computadora.establecerAlmacenamiento("1TB SSD");
        computadora.establecerTarjetaGrafica("NVIDIA RTX 3080");
        computadora.establecerPlacaMadre("ASUS ROG");
        computadora.establecerFuente("750W");
        computadora.establecerRefrigeracion("Refrigeración Líquida");

        computadora.mostrarEspecificaciones();

        Computadora gaming = new Computadora();
        gaming.establecerProcesador("AMD Ryzen 9");
        gaming.establecerMemoria("32GB RAM");
        gaming.establecerAlmacenamiento("2TB SSD");
        gaming.establecerTarjetaGrafica("NVIDIA RTX 4090");

        gaming.mostrarEspecificaciones();
    }
}

class Computadora {
    private String procesador;
    private String memoria;
    private String almacenamiento;
    private String tarjetaGrafica;
    private String placaMadre;
    private String fuente;
    private String refrigeracion;

    public void establecerProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void establecerMemoria(String memoria) {
        this.memoria = memoria;
    }

    public void establecerAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void establecerTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public void establecerPlacaMadre(String placaMadre) {
        this.placaMadre = placaMadre;
    }

    public void establecerFuente(String fuente) {
        this.fuente = fuente;
    }

    public void establecerRefrigeracion(String refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    public void mostrarEspecificaciones() {
        System.out.println("=== Especificaciones de la Computadora ===");
        if (procesador != null)
            System.out.println("Procesador: " + procesador);
        if (memoria != null)
            System.out.println("Memoria: " + memoria);
        if (almacenamiento != null)
            System.out.println("Almacenamiento: " + almacenamiento);
        if (tarjetaGrafica != null)
            System.out.println("Tarjeta gráfica: " + tarjetaGrafica);
        if (placaMadre != null)
            System.out.println("Placa madre: " + placaMadre);
        if (fuente != null)
            System.out.println("Fuente: " + fuente);
        if (refrigeracion != null)
            System.out.println("Refrigeración: " + refrigeracion);
        System.out.println();
    }
}