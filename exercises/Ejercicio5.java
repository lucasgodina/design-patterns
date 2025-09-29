public class Ejercicio5 {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        Group mainGroup = new Group();
        mainGroup.add(circle);
        mainGroup.add(rectangle);

        Group subGroup = new Group();
        subGroup.add(new Circle());
        subGroup.add(new Rectangle());

        mainGroup.add(subGroup);

        mainGroup.draw();
    }
}

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    public void draw() {
        System.out.println("Dibujando un círculo");
    }
}

class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Dibujando un rectángulo");
    }
}

abstract class Shape implements Drawable {
}

class Group extends Shape {
    private java.util.List<Drawable> shapes = new java.util.ArrayList<>();

    public void add(Drawable shape) {
        shapes.add(shape);
    }

    public void remove(Drawable shape) {
        shapes.remove(shape);
    }

    public void draw() {
        System.out.println("Dibujando grupo:");
        for (Drawable shape : shapes) {
            shape.draw();
        }
    }
}