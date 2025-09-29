public class Ejercicio3 {

    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.setProcessor("Intel i7");
        computer.setMemory("16GB RAM");
        computer.setStorage("1TB SSD");
        computer.setGraphicsCard("NVIDIA RTX 3080");
        computer.setMotherboard("ASUS ROG");
        computer.setPowerSupply("750W");
        computer.setCoolingSystem("Liquid Cooling");

        computer.displaySpecs();

        Computer gaming = new Computer();
        gaming.setProcessor("AMD Ryzen 9");
        gaming.setMemory("32GB RAM");
        gaming.setStorage("2TB SSD");
        gaming.setGraphicsCard("NVIDIA RTX 4090");

        gaming.displaySpecs();
    }
}

class Computer {
    private String processor;
    private String memory;
    private String storage;
    private String graphicsCard;
    private String motherboard;
    private String powerSupply;
    private String coolingSystem;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public void setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public void displaySpecs() {
        System.out.println("=== Especificaciones de la Computadora ===");
        if (processor != null)
            System.out.println("Procesador: " + processor);
        if (memory != null)
            System.out.println("Memoria: " + memory);
        if (storage != null)
            System.out.println("Almacenamiento: " + storage);
        if (graphicsCard != null)
            System.out.println("Tarjeta gráfica: " + graphicsCard);
        if (motherboard != null)
            System.out.println("Placa madre: " + motherboard);
        if (powerSupply != null)
            System.out.println("Fuente: " + powerSupply);
        if (coolingSystem != null)
            System.out.println("Refrigeración: " + coolingSystem);
        System.out.println();
    }
}