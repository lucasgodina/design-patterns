public class Ejercicio7 {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Laptop", 1500.0);
        cart.addItem("Mouse", 25.0);
        cart.addItem("Teclado", 75.0);

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment(cart, "credit");
        processor.processPayment(cart, "paypal");
        processor.processPayment(cart, "crypto");
    }
}

class ShoppingCart {
    private java.util.List<Item> items = new java.util.ArrayList<>();

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public double getTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
    }
}

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class PaymentProcessor {
    public void processPayment(ShoppingCart cart, String method) {
        double total = cart.getTotal();

        if (method.equals("credit")) {
            System.out.println("Procesando pago con tarjeta de crédito por $" + total);
            System.out.println("Validando número de tarjeta...");
            System.out.println("Verificando fondos...");
            System.out.println("Pago aprobado");
        } else if (method.equals("paypal")) {
            System.out.println("Procesando pago con PayPal por $" + total);
            System.out.println("Redirigiendo a PayPal...");
            System.out.println("Autenticación exitosa");
            System.out.println("Pago completado");
        } else if (method.equals("crypto")) {
            System.out.println("Procesando pago con criptomonedas por $" + total);
            System.out.println("Generando dirección de wallet...");
            System.out.println("Confirmando transacción en blockchain...");
            System.out.println("Pago verificado");
        }
        System.out.println();
    }
}