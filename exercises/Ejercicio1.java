public class Ejercicio1 {

    public static void main(String[] args) {
        DatabaseConnection conn1 = new DatabaseConnection();
        DatabaseConnection conn2 = new DatabaseConnection();
        DatabaseConnection conn3 = new DatabaseConnection();

        System.out.println("Conexión 1: " + conn1.getConnectionId());
        System.out.println("Conexión 2: " + conn2.getConnectionId());
        System.out.println("Conexión 3: " + conn3.getConnectionId());
    }
}

class DatabaseConnection {
    private static int connectionCount = 0;
    private int connectionId;

    public DatabaseConnection() {
        connectionCount++;
        this.connectionId = connectionCount;
        System.out.println("Nueva conexión a base de datos creada. ID: " + connectionId);
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void executeQuery(String query) {
        System.out.println("Ejecutando query en conexión " + connectionId + ": " + query);
    }
}