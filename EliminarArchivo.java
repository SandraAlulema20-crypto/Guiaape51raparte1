import java.io.File;

public class EliminarArchivo {
    public static void main(String[] args) {
        
        // 1. Crear un objeto de tipo File indicando el nombre del archivo a eliminar
        File archivo = new File("estudiantes.txt");
        
        // 2. Utilizar el método delete() junto con un bloque if-else para comprobar el resultado
        if (archivo.delete()) {
            // 3. Si el archivo se eliminó, mostrar un mensaje de confirmación
            System.out.println("El archivo 'estudiantes.txt' se eliminó correctamente.");
        } else {
            // 4. Si no se pudo eliminar, mostrar un mensaje indicando el problema
            System.out.println("No se pudo eliminar el archivo. Verifique si el archivo existe o si está siendo usado por otro programa.");
        }
    }
}
