El patrón Adapter (Adaptador) se utiliza para permitir que la interfaz de una clase existente sea utiliza como otra interfaz. Su propósito es traducir la interfaz de una clase a otra que el cliente espera, permitiendo que clases incompatibles colaboren.

Una forma de pensar este adaptador es como un traductor universal o un adaptador de corriente: el cliente (el enchufe) espera una forma, pero el servidor (la pared) ofrece otra, y el adaptadar las hace compatibles.

En este ejemplo, vamos a implementar un adaptador para una aplicación la cual requiere que todos los servicios de carga de datos usen una interfaz moderna (CargadorDatosModerno). Queremos inegrar un servicio de datos antiguo (ServicioDatosXML) que no puede modificarse y utiliza un método completamente diferente.

Sin el patrón Adapter, no podríamos usar el ServicioDatosXML directamente en nuestra aplicación, ya que su interfaz no coincide con la que esperamos.
