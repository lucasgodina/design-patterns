package structural.adapter.java;

// Ventajas de usar el patrón Adapter:
// 1. Reutilización de código: Permite integrar clases existentes sin modificar su código.
// 2. Desacoplamiento de interfaces: El cliente no necesita conocer los detalles de la clase adaptada.
// 3. Cumple OCP: Nuevas clases adaptadas pueden ser añadidas sin cambiar el código del cliente.

// Interfaz que el cliente espera (Target)
interface CargadorDatosModerno {
    // El cliente espera que la carga se haga con un objeto de tipo JsonData
    void cargarDatos(String jsonData);
}

// Clase cliente que usa la interfaz Target
class ProcesadorInformacion {
    public void procesar(CargadorDatosModerno cargador) {
        System.out.println("Procesador: Pidiendo carga de datos en formato JSON...");
        // Simulación de datos en formato JSON
        String datosJson = "{ \"nombre\": \"Adaptador\", \"tipo\": \"Estructural\" }";
        cargador.cargarDatos(datosJson);
    }
}

// Clase incompatible que queremos usar (Adaptee)
class ServicioDatosXML {
    // El método tiene un nombre diferente y espera un formato de datos diferente
    public void cargarXML(String datosXml) {
        System.out.println("Servicio XML: Datos XML ('" + datosXml + "') cargados en el sistema antiguo.");
    }
}

// El adaptador
// Implementa la interfaz esperada por el cliente y envuelve a la clase
// incompatible.
class AdaptadorDatosXML implements CargadorDatosModerno {
    private ServicioDatosXML servicioAntiguo;

    public AdaptadorDatosXML(ServicioDatosXML servicioAntiguo) {
        this.servicioAntiguo = servicioAntiguo;
    }

    // El método de adaptación (Traducción)
    @Override
    public void cargarDatos(String jsonData) {
        System.out.println("Adaptador: Recibiendo JSON. Iniciando traducción a XML...");

        // Traducción (La lógica clave del Adapter)
        // Aquí se simula la conversión de JSON a XML.
        String datosXml = "<data><nombre>Adaptador</nombre><tipo>Estructural</tipo></data>";

        // Llamada al método de la clase incompatible
        servicioAntiguo.cargarXML(datosXml);

        System.out.println(" Adaptador: Carga completada con éxito.");
    }
}

// Clase principal para ejecutar el ejemplo con el patrón Adapter
public class ConPatron {
    public static void main(String[] args) {
        ProcesadorInformacion procesador = new ProcesadorInformacion();

        // La clase incompatible
        ServicioDatosXML servicioAntiguo = new ServicioDatosXML();

        // Creamos el adaptador, pasándole el objeto incompatible
        CargadorDatosModerno adaptador = new AdaptadorDatosXML(servicioAntiguo);

        // El procesador llama al adaptador, pensando que es un cargador moderno
        // El adaptador, internamente, traduce y llama al servicio antiguo
        procesador.procesar(adaptador);
    }
}
