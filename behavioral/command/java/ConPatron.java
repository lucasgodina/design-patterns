package behavioral.command.java;

// Ventajas de aplicar este patrón:
// 1. Desacoplamiento: El control remoto (Invoker) no necesita conocer los detalles de cómo se ejecuta un comando. Solo interactúa con la interfaz Command.
// 2. Extensibilidad: Se pueden añadir nuevos comandos para controlar otros dispositivos (como un equipo de sonido o un ventilador) sin modificar la clase ControlRemoto.
// 3. Flexibilidad: Los comandos pueden ser almacenados, encolados o revertidos, lo que permite implementar funcionalidades avanzadas como "deshacer".
// 4. Encapsulación: Cada comando encapsula una solicitud completa, incluyendo el método a llamar y los parámetros necesarios, en un único objeto.

// Clase de la televisión (Receiver)
class Television {
    public void encender() {
        System.out.println("Televisión encendida");
    }

    public void apagar() {
        System.out.println("Televisión apagada");
    }
}

// Clase del control remoto (Invoker)
class ControlRemoto {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void presionarBoton() {
        if (command != null) {
            command.ejecutar();
        } else {
            System.out.println("No hay comando asignado");
        }
    }
}

// Interfaz del comando
interface Command {
    void ejecutar();
}

// Interfaces concretas de comandos
class EncenderTelevisionCommand implements Command {
    private Television television;

    public EncenderTelevisionCommand(Television television) {
        this.television = television;
    }

    @Override
    public void ejecutar() {
        television.encender();
    }
}

class ApagarTelevisionCommand implements Command {
    private Television television;

    public ApagarTelevisionCommand(Television television) {
        this.television = television;
    }

    @Override
    public void ejecutar() {
        television.apagar();
    }
}

// Clase principal para demostrar el uso del patrón Command
public class ConPatron {
    public static void main(String[] args) {
        // 1. Crear el receptor
        Television television = new Television();

        // 2. Crear los comandos concretos, pasándoles el receptor
        Command encenderCommand = new EncenderTelevisionCommand(television);
        Command apagarCommand = new ApagarTelevisionCommand(television);

        // 3. Crear el invocador
        ControlRemoto controlRemoto = new ControlRemoto();

        // 4. Asignar y ejecutar comandos
        controlRemoto.setCommand(encenderCommand);
        controlRemoto.presionarBoton();

        controlRemoto.setCommand(apagarCommand);
        controlRemoto.presionarBoton();
    }
}