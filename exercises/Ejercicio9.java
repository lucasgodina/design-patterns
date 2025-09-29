public class Ejercicio9 {

    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " - $" + simpleCoffee.getCost());

        Coffee coffeeWithMilk = new SimpleCoffee();
        coffeeWithMilk = addMilk(coffeeWithMilk);
        System.out.println(coffeeWithMilk.getDescription() + " - $" + coffeeWithMilk.getCost());

        Coffee coffeeWithSugar = new SimpleCoffee();
        coffeeWithSugar = addSugar(coffeeWithSugar);
        System.out.println(coffeeWithSugar.getDescription() + " - $" + coffeeWithSugar.getCost());

        Coffee deluxeCoffee = new SimpleCoffee();
        deluxeCoffee = addMilk(deluxeCoffee);
        deluxeCoffee = addSugar(deluxeCoffee);
        deluxeCoffee = addChocolate(deluxeCoffee);
        System.out.println(deluxeCoffee.getDescription() + " - $" + deluxeCoffee.getCost());
    }

    public static Coffee addMilk(Coffee coffee) {
        return new CoffeeWithMilk(coffee);
    }

    public static Coffee addSugar(Coffee coffee) {
        return new CoffeeWithSugar(coffee);
    }

    public static Coffee addChocolate(Coffee coffee) {
        return new CoffeeWithChocolate(coffee);
    }
}

interface Coffee {
    String getDescription();

    double getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Café simple";
    }

    public double getCost() {
        return 2.0;
    }
}

class CoffeeWithMilk implements Coffee {
    private Coffee coffee;

    public CoffeeWithMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + " + Leche";
    }

    public double getCost() {
        return coffee.getCost() + 0.5;
    }
}

class CoffeeWithSugar implements Coffee {
    private Coffee coffee;

    public CoffeeWithSugar(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + " + Azúcar";
    }

    public double getCost() {
        return coffee.getCost() + 0.25;
    }
}

class CoffeeWithChocolate implements Coffee {
    private Coffee coffee;

    public CoffeeWithChocolate(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + " + Chocolate";
    }

    public double getCost() {
        return coffee.getCost() + 0.75;
    }
}