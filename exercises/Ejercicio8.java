public class Ejercicio8 {

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        remote.setCommand("turn on light");
        remote.executeCommand();

        remote.setCommand("turn off light");
        remote.executeCommand();

        remote.setCommand("turn on fan");
        remote.executeCommand();

        remote.setCommand("set fan speed high");
        remote.executeCommand();

        remote.setCommand("turn on stereo");
        remote.executeCommand();

        remote.setCommand("set volume 50");
        remote.executeCommand();
    }
}

class RemoteControl {
    private String currentCommand;
    private Light light = new Light();
    private Fan fan = new Fan();
    private Stereo stereo = new Stereo();

    public void setCommand(String command) {
        this.currentCommand = command;
    }

    public void executeCommand() {
        if (currentCommand.equals("turn on light")) {
            light.turnOn();
        } else if (currentCommand.equals("turn off light")) {
            light.turnOff();
        } else if (currentCommand.equals("turn on fan")) {
            fan.turnOn();
        } else if (currentCommand.equals("turn off fan")) {
            fan.turnOff();
        } else if (currentCommand.equals("set fan speed high")) {
            fan.setSpeed("high");
        } else if (currentCommand.equals("turn on stereo")) {
            stereo.turnOn();
        } else if (currentCommand.equals("turn off stereo")) {
            stereo.turnOff();
        } else if (currentCommand.startsWith("set volume")) {
            int volume = Integer.parseInt(currentCommand.split(" ")[2]);
            stereo.setVolume(volume);
        }
    }
}

class Light {
    public void turnOn() {
        System.out.println("Luz encendida");
    }

    public void turnOff() {
        System.out.println("Luz apagada");
    }
}

class Fan {
    public void turnOn() {
        System.out.println("Ventilador encendido");
    }

    public void turnOff() {
        System.out.println("Ventilador apagado");
    }

    public void setSpeed(String speed) {
        System.out.println("Velocidad del ventilador: " + speed);
    }
}

class Stereo {
    public void turnOn() {
        System.out.println("Estéreo encendido");
    }

    public void turnOff() {
        System.out.println("Estéreo apagado");
    }

    public void setVolume(int volume) {
        System.out.println("Volumen: " + volume);
    }
}