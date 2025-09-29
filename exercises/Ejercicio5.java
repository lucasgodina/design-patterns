public class Ejercicio5 {

    public static void main(String[] args) {
        Circulo circulo = new Circulo();
        Rectangulo rectangulo = new Rectangulo();

        Grupo grupoPrincipal = new Grupo();
        grupoPrincipal.agregar(circulo);
        grupoPrincipal.agregar(rectangulo);

        Grupo subGrupo = new Grupo();
        subGrupo.agregar(new Circulo());
        subGrupo.agregar(new Rectangulo());

        grupoPrincipal.agregar(subGrupo);

        grupoPrincipal.dibujar();
    }
}

interface Dibujable {
    void dibujar();
}

class Circulo implements Dibujable {
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

class Rectangulo implements Dibujable {
    public void dibujar() {
        System.out.println("Dibujando un rectángulo");
    }
}

abstract class Forma implements Dibujable {
}

class Grupo extends Forma {
    private java.util.List<Dibujable> formas = new java.util.ArrayList<>();

    public void agregar(Dibujable forma) {
        formas.add(forma);
    }

    public void remover(Dibujable forma) {
        formas.remove(forma);
    }

    public void dibujar() {
        System.out.println("Dibujando grupo:");
        for (Dibujable forma : formas) {
            forma.dibujar();
        }
    }
}