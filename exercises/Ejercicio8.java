public class Ejercicio8 {

    public static void main(String[] args) {
        ControlRemoto control = new ControlRemoto();

        control.establecerComando("encender luz");
        control.ejecutarComando();

        control.establecerComando("apagar luz");
        control.ejecutarComando();

        control.establecerComando("encender ventilador");
        control.ejecutarComando();

        control.establecerComando("velocidad ventilador alta");
        control.ejecutarComando();

        control.establecerComando("encender estereo");
        control.ejecutarComando();

        control.establecerComando("volumen 50");
        control.ejecutarComando();
    }
}

class ControlRemoto {
    private String comandoActual;
    private Luz luz = new Luz();
    private Ventilador ventilador = new Ventilador();
    private Estereo estereo = new Estereo();

    public void establecerComando(String comando) {
        this.comandoActual = comando;
    }

    public void ejecutarComando() {
        if (comandoActual.equals("encender luz")) {
            luz.encender();
        } else if (comandoActual.equals("apagar luz")) {
            luz.apagar();
        } else if (comandoActual.equals("encender ventilador")) {
            ventilador.encender();
        } else if (comandoActual.equals("apagar ventilador")) {
            ventilador.apagar();
        } else if (comandoActual.equals("velocidad ventilador alta")) {
            ventilador.establecerVelocidad("alta");
        } else if (comandoActual.equals("encender estereo")) {
            estereo.encender();
        } else if (comandoActual.equals("apagar estereo")) {
            estereo.apagar();
        } else if (comandoActual.startsWith("volumen")) {
            int volumen = Integer.parseInt(comandoActual.split(" ")[1]);
            estereo.establecerVolumen(volumen);
        }
    }
}

class Luz {
    public void encender() {
        System.out.println("Luz encendida");
    }

    public void apagar() {
        System.out.println("Luz apagada");
    }
}

class Ventilador {
    public void encender() {
        System.out.println("Ventilador encendido");
    }

    public void apagar() {
        System.out.println("Ventilador apagado");
    }

    public void establecerVelocidad(String velocidad) {
        System.out.println("Velocidad del ventilador: " + velocidad);
    }
}

class Estereo {
    public void encender() {
        System.out.println("Estéreo encendido");
    }

    public void apagar() {
        System.out.println("Estéreo apagado");
    }

    public void establecerVolumen(int volumen) {
        System.out.println("Volumen: " + volumen);
    }
}