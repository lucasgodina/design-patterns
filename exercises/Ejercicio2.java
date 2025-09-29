public class Ejercicio2 {

    public static void main(String[] args) {
        FabricaProductos fabrica = new FabricaProductos();

        Producto laptop = fabrica.crearProducto("laptop", "Dell XPS", 1500.0);
        Producto telefono = fabrica.crearProducto("telefono", "iPhone 14", 999.0);
        Producto tableta = fabrica.crearProducto("tableta", "iPad Pro", 1200.0);

        laptop.mostrarInformacion();
        telefono.mostrarInformacion();
        tableta.mostrarInformacion();
    }
}

class FabricaProductos {
    public Producto crearProducto(String tipo, String nombre, double precio) {
        if (tipo.equals("laptop")) {
            return new Producto("Laptop", nombre, precio, "Computadora portátil");
        } else if (tipo.equals("telefono")) {
            return new Producto("Teléfono", nombre, precio, "Dispositivo móvil");
        } else if (tipo.equals("tableta")) {
            return new Producto("Tableta", nombre, precio, "Dispositivo táctil");
        }
        return null;
    }
}

class Producto {
    private String categoria;
    private String nombre;
    private double precio;
    private String descripcion;

    public Producto(String categoria, String nombre, double precio, String descripcion) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public void mostrarInformacion() {
        System.out.println(categoria + ": " + nombre + " - $" + precio + " (" + descripcion + ")");
    }
}