public class Ejercicio6 {

    public static void main(String[] args) {
        AgenciaNoticias agencia = new AgenciaNoticias();

        CanalNoticias canal1 = new CanalNoticias("Canal 1");
        CanalNoticias canal2 = new CanalNoticias("Canal 2");
        Periodico periodico = new Periodico("Diario Nacional");

        agencia.agregarSuscriptor(canal1);
        agencia.agregarSuscriptor(canal2);
        agencia.agregarSuscriptor(periodico);

        agencia.publicarNoticia("Gran descubrimiento científico");

        agencia.removerSuscriptor(canal2);

        agencia.publicarNoticia("Nuevas medidas económicas");
    }
}

class AgenciaNoticias {
    private java.util.List<SuscriptorNoticias> suscriptores = new java.util.ArrayList<>();
    private String ultimaNoticia;

    public void agregarSuscriptor(SuscriptorNoticias suscriptor) {
        suscriptores.add(suscriptor);
    }

    public void removerSuscriptor(SuscriptorNoticias suscriptor) {
        suscriptores.remove(suscriptor);
    }

    public void publicarNoticia(String noticia) {
        this.ultimaNoticia = noticia;
        notificarTodosSuscriptores();
    }

    private void notificarTodosSuscriptores() {
        for (SuscriptorNoticias suscriptor : suscriptores) {
            suscriptor.actualizar(ultimaNoticia);
        }
    }
}

interface SuscriptorNoticias {
    void actualizar(String noticia);
}

class CanalNoticias implements SuscriptorNoticias {
    private String nombre;

    public CanalNoticias(String nombre) {
        this.nombre = nombre;
    }

    public void actualizar(String noticia) {
        System.out.println(nombre + " reporta: " + noticia);
    }
}

class Periodico implements SuscriptorNoticias {
    private String nombre;

    public Periodico(String nombre) {
        this.nombre = nombre;
    }

    public void actualizar(String noticia) {
        System.out.println(nombre + " publica: " + noticia);
    }
}