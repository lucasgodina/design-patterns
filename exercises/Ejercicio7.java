public class Ejercicio7 {

    public static void main(String[] args) {
        CarritoCompras carrito = new CarritoCompras();

        carrito.agregarArticulo("Laptop", 1500.0);
        carrito.agregarArticulo("Mouse", 25.0);
        carrito.agregarArticulo("Teclado", 75.0);

        ProcesadorPagos procesador = new ProcesadorPagos();

        procesador.procesarPago(carrito, "tarjeta");
        procesador.procesarPago(carrito, "paypal");
        procesador.procesarPago(carrito, "cripto");
    }
}

class CarritoCompras {
    private java.util.List<Articulo> articulos = new java.util.ArrayList<>();

    public void agregarArticulo(String nombre, double precio) {
        articulos.add(new Articulo(nombre, precio));
    }

    public double obtenerTotal() {
        return articulos.stream().mapToDouble(Articulo::obtenerPrecio).sum();
    }

    public void mostrarArticulos() {
        for (Articulo articulo : articulos) {
            System.out.println("- " + articulo.obtenerNombre() + ": $" + articulo.obtenerPrecio());
        }
    }
}

class Articulo {
    private String nombre;
    private double precio;

    public Articulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public double obtenerPrecio() {
        return precio;
    }
}

class ProcesadorPagos {
    public void procesarPago(CarritoCompras carrito, String metodo) {
        double total = carrito.obtenerTotal();

        if (metodo.equals("tarjeta")) {
            System.out.println("Procesando pago con tarjeta de crédito por $" + total);
            System.out.println("Validando número de tarjeta...");
            System.out.println("Verificando fondos...");
            System.out.println("Pago aprobado");
        } else if (metodo.equals("paypal")) {
            System.out.println("Procesando pago con PayPal por $" + total);
            System.out.println("Redirigiendo a PayPal...");
            System.out.println("Autenticación exitosa");
            System.out.println("Pago completado");
        } else if (metodo.equals("cripto")) {
            System.out.println("Procesando pago con criptomonedas por $" + total);
            System.out.println("Generando dirección de billetera...");
            System.out.println("Confirmando transacción en blockchain...");
            System.out.println("Pago verificado");
        }
        System.out.println();
    }
}