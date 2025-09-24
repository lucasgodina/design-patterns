package behavioral.command.java;

// El problema en esta implementación sin patrón es que la clase ControlRemoto está fuertemente acoplada a la clase Television.
// Si se desea cambiar la funcionalidad del control remoto o agregar nuevos dispositivos, se tendría que modificar esta clase directamente.
// Esto viola el principio de abierto/cerrado, ya que la clase ControlRemoto no está abierta para extensión sin modificación.

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
    private Television television;

    public ControlRemoto(Television television) {
        this.television = television;
    }

    public void presionarBotonEncender() {
        television.encender();
    }

    public void presionarBotonApagar() {
        television.apagar();
    }
}

// Clase principal para demostrar el uso del control remoto
public class SinPatron {
    public static void main(String[] args) {
        Television television = new Television();
        ControlRemoto controlRemoto = new ControlRemoto(television);

        controlRemoto.presionarBotonEncender();
        controlRemoto.presionarBotonApagar();
    }
}