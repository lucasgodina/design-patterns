public class Ejercicio2 {

    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();

        Product laptop = factory.createProduct("laptop", "Dell XPS", 1500.0);
        Product phone = factory.createProduct("phone", "iPhone 14", 999.0);
        Product tablet = factory.createProduct("tablet", "iPad Pro", 1200.0);

        laptop.displayInfo();
        phone.displayInfo();
        tablet.displayInfo();
    }
}

class ProductFactory {
    public Product createProduct(String type, String name, double price) {
        if (type.equals("laptop")) {
            return new Product("Laptop", name, price, "Computadora portátil");
        } else if (type.equals("phone")) {
            return new Product("Teléfono", name, price, "Dispositivo móvil");
        } else if (type.equals("tablet")) {
            return new Product("Tablet", name, price, "Dispositivo táctil");
        }
        return null;
    }
}

class Product {
    private String category;
    private String name;
    private double price;
    private String description;

    public Product(String category, String name, double price, String description) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void displayInfo() {
        System.out.println(category + ": " + name + " - $" + price + " (" + description + ")");
    }
}