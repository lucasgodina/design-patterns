El patrón Composite (Compuesto) permite que los objetos individuales y las composiciones de objetos (grupos) se traten de manera uniforme.

El objetivo es componer objetos en estructuras de árbol para representar jerarquías de parte-todo. Con este patrón, un cliente puede tratar a un objeto individual (Hoja) de la misma manera que trata a una colección de objetos (Compuesto).

En este ejemplo, vamos a implementar un sistema de archivos en el cual tenemos que averiguar el tamaño total de un directorio. Los elementos pueden ser un Archivo (Hoja) o una Carpeta (elemento compuesto que contiene otros archivos o subcarpetas).
