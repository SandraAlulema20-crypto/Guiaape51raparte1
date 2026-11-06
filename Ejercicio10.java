import java.io.File;
import java.io.IOException;

public class Ejercicio10 {
    public static void main(String[] args) {
        // 1. Objeto File con la ruta indicada
        File archivo = new File("datos/temporal.txt");

        // Se crea la carpeta "datos" si no existe
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }

        // 2. Consultar estado y crear si no existe
        if (!archivo.exists()) {
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado: " + archivo.getPath());
                }
            } catch (IOException e) {
                System.out.println("Error de E/S al crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo ya existe: " + archivo.getPath());
        }

        // 3. Simulación de confirmación del usuario
        boolean confirmarBorrado = true;

        // 4. Borrar solo si hay confirmación
        if (confirmarBorrado) {
            boolean eliminado = archivo.delete();
            System.out.println("Resultado de delete(): " + eliminado);
        } else {
            System.out.println("Borrado cancelado por el usuario.");
        }
    }
}
