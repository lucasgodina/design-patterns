public class Ejercicio9 {

    public static void main(String[] args) {
        Cafe cafeSimple = new CafeSimple();
        System.out.println(cafeSimple.obtenerDescripcion() + " - $" + cafeSimple.obtenerCosto());

        Cafe cafeConLeche = new CafeSimple();
        cafeConLeche = agregarLeche(cafeConLeche);
        System.out.println(cafeConLeche.obtenerDescripcion() + " - $" + cafeConLeche.obtenerCosto());

        Cafe cafeConAzucar = new CafeSimple();
        cafeConAzucar = agregarAzucar(cafeConAzucar);
        System.out.println(cafeConAzucar.obtenerDescripcion() + " - $" + cafeConAzucar.obtenerCosto());

        Cafe cafeDeluxe = new CafeSimple();
        cafeDeluxe = agregarLeche(cafeDeluxe);
        cafeDeluxe = agregarAzucar(cafeDeluxe);
        cafeDeluxe = agregarChocolate(cafeDeluxe);
        System.out.println(cafeDeluxe.obtenerDescripcion() + " - $" + cafeDeluxe.obtenerCosto());
    }

    public static Cafe agregarLeche(Cafe cafe) {
        return new CafeConLeche(cafe);
    }

    public static Cafe agregarAzucar(Cafe cafe) {
        return new CafeConAzucar(cafe);
    }

    public static Cafe agregarChocolate(Cafe cafe) {
        return new CafeConChocolate(cafe);
    }
}

interface Cafe {
    String obtenerDescripcion();

    double obtenerCosto();
}

class CafeSimple implements Cafe {
    public String obtenerDescripcion() {
        return "Café simple";
    }

    public double obtenerCosto() {
        return 2.0;
    }
}

class CafeConLeche implements Cafe {
    private Cafe cafe;

    public CafeConLeche(Cafe cafe) {
        this.cafe = cafe;
    }

    public String obtenerDescripcion() {
        return cafe.obtenerDescripcion() + " + Leche";
    }

    public double obtenerCosto() {
        return cafe.obtenerCosto() + 0.5;
    }
}

class CafeConAzucar implements Cafe {
    private Cafe cafe;

    public CafeConAzucar(Cafe cafe) {
        this.cafe = cafe;
    }

    public String obtenerDescripcion() {
        return cafe.obtenerDescripcion() + " + Azúcar";
    }

    public double obtenerCosto() {
        return cafe.obtenerCosto() + 0.25;
    }
}

class CafeConChocolate implements Cafe {
    private Cafe cafe;

    public CafeConChocolate(Cafe cafe) {
        this.cafe = cafe;
    }

    public String obtenerDescripcion() {
        return cafe.obtenerDescripcion() + " + Chocolate";
    }

    public double obtenerCosto() {
        return cafe.obtenerCosto() + 0.75;
    }
}