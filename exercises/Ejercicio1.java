public class Ejercicio1 {

    public static void main(String[] args) {
        ConexionBaseDatos conexion1 = new ConexionBaseDatos();
        ConexionBaseDatos conexion2 = new ConexionBaseDatos();
        ConexionBaseDatos conexion3 = new ConexionBaseDatos();

        System.out.println("Conexión 1: " + conexion1.obtenerIdConexion());
        System.out.println("Conexión 2: " + conexion2.obtenerIdConexion());
        System.out.println("Conexión 3: " + conexion3.obtenerIdConexion());
    }
}

class ConexionBaseDatos {
    private static int contadorConexiones = 0;
    private int idConexion;

    public ConexionBaseDatos() {
        contadorConexiones++;
        this.idConexion = contadorConexiones;
        System.out.println("Nueva conexión a base de datos creada. ID: " + idConexion);
    }

    public int obtenerIdConexion() {
        return idConexion;
    }

    public void ejecutarConsulta(String consulta) {
        System.out.println("Ejecutando consulta en conexión " + idConexion + ": " + consulta);
    }
}