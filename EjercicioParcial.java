// Sistema de E-commerce sin patrones aplicados
// Identifica qué patrones de diseño podrían mejorar este código y explica por qué

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nombre;
    private String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}

class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }
}

class Pedido {
    private Usuario usuario;
    private List<Producto> productos;
    private String estado;
    private double total;
    private EmailService emailService;
    private SMSService smsService;
    private PushNotificationService pushService;

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
        this.productos = new ArrayList<>();
        this.estado = "PENDIENTE";
        this.emailService = new EmailService();
        this.smsService = new SMSService();
        this.pushService = new PushNotificationService();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    public void calcularTotal() {
        total = 0;
        for (Producto producto : productos) {
            if (producto.getCategoria().equals("ELECTRONICO")) {
                total += producto.getPrecio() + (producto.getPrecio() * 0.21);
            } else if (producto.getCategoria().equals("ROPA")) {
                total += producto.getPrecio() + (producto.getPrecio() * 0.15);
            } else if (producto.getCategoria().equals("LIBRO")) {
                total += producto.getPrecio() + (producto.getPrecio() * 0.10);
            } else {
                total += producto.getPrecio() + (producto.getPrecio() * 0.18);
            }
        }
    }

    public void procesarPago() {
        estado = "PAGADO";
        notificarCambioEstado();
    }

    public void enviarPedido() {
        estado = "ENVIADO";
        notificarCambioEstado();
    }

    public void completarPedido() {
        estado = "COMPLETADO";
        notificarCambioEstado();
    }

    private void notificarCambioEstado() {
        emailService.enviarEmail(usuario.getEmail(), "Estado del pedido: " + estado);
        smsService.enviarSMS(usuario.getNombre(), "Su pedido está: " + estado);
        pushService.enviarNotificacion(usuario.getNombre(), "Pedido " + estado);
    }

    public String getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }
}

class CarritoCompras {
    private Usuario usuario;
    private List<Producto> productos;

    public CarritoCompras(Usuario usuario) {
        this.usuario = usuario;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Pedido crearPedido() {
        Pedido pedido = new Pedido(usuario);
        for (Producto producto : productos) {
            pedido.agregarProducto(producto);
        }
        return pedido;
    }
}

class TiendaOnline {
    private List<Producto> inventario;

    public TiendaOnline() {
        this.inventario = new ArrayList<>();
        inicializarInventario();
    }

    private void inicializarInventario() {
        inventario.add(crearProductoElectronico("Smartphone", 500.0));
        inventario.add(crearProductoRopa("Camiseta", 25.0));
        inventario.add(crearProductoLibro("Java Programming", 45.0));
    }

    public Producto crearProductoElectronico(String nombre, double precio) {
        return new Producto(nombre, precio, "ELECTRONICO");
    }

    public Producto crearProductoRopa(String nombre, double precio) {
        return new Producto(nombre, precio, "ROPA");
    }

    public Producto crearProductoLibro(String nombre, double precio) {
        return new Producto(nombre, precio, "LIBRO");
    }

    public List<Producto> getInventario() {
        return inventario;
    }
}

class EmailService {
    public void enviarEmail(String email, String mensaje) {
        System.out.println("Email enviado a " + email + ": " + mensaje);
    }
}

class SMSService {
    public void enviarSMS(String nombre, String mensaje) {
        System.out.println("SMS enviado a " + nombre + ": " + mensaje);
    }
}

class PushNotificationService {
    public void enviarNotificacion(String nombre, String mensaje) {
        System.out.println("Push notification enviada a " + nombre + ": " + mensaje);
    }
}

public class EjercicioParcial {
    public static void main(String[] args) {
        TiendaOnline tienda = new TiendaOnline();
        Usuario usuario = new Usuario("Juan Pérez", "juan@email.com");
        CarritoCompras carrito = new CarritoCompras(usuario);

        carrito.agregarProducto(tienda.crearProductoElectronico("Laptop", 800.0));
        carrito.agregarProducto(tienda.crearProductoRopa("Pantalón", 40.0));

        Pedido pedido = carrito.crearPedido();
        System.out.println("Total del pedido: $" + pedido.getTotal());

        pedido.procesarPago();
        pedido.enviarPedido();
        pedido.completarPedido();
    }
}