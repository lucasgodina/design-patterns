package structural.adapter.java;

// Sin aplicar el patrón Adapter no podemos integrar clases con interfaces incompatibles.
// En este caso, no podemos usar ServicioDatosXML directamente en nuestra aplicación
// porque su interfaz no coincide con la que esperamos (CargadorDatosModerno).

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

// Clase compatible con la interfaz (para referencia)
class CargadorDeAPI implements CargadorDatosModerno {
    @Override
    public void cargarDatos(String jsonData) {
        System.out.println("Cargador De API: JSON Recibido y procesado correctamente.");
    }
}

// Clase incompatible que queremos usar (Adaptee)
// Esta clase SÓLO sabe trabajar con XML y no implementa la interfaz moderna.
class ServicioDatosXML {
    // El método tiene un nombre diferente y espera un formato de datos diferente
    public void cargarXML(String datosXml) {
        System.out.println("Servicio XML: Datos XML ('" + datosXml + "') cargados en el sistema antiguo.");
    }
}

// Clase principal para ejecutar el ejemplo sin el patrón Adapter
public class SinPatron {
    public static void main(String[] args) {
        ProcesadorInformacion procesador = new ProcesadorInformacion();

        // El procesador funciona con cargadores compatibles (JSON)
        CargadorDeAPI cargadorApi = new CargadorDeAPI();
        procesador.procesar(cargadorApi);

        System.out.println("----------------------------------");

        // Problema: La clase ServicioDatosXML es incompatible.
        // ServicioDatosXML servicioXml = new ServicioDatosXML();
        // procesador.procesar(servicioXml); // Esto da un error de compilación!

        System.out.println("Problema: El procesador solo acepta CargadorDatosModerno.");
        System.out.println("No podemos pasarle directamente el ServicioDatosXML porque sus interfaces no coinciden.");
    }
}
