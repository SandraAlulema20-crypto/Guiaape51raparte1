import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1GuardarInformacion {
    public static void main(String[] args) {
        String nombreArchivo = "curso.txt";

        // Se utiliza try-with-resources para asegurar el cierre del flujo de datos
        try (FileWriter fw = new FileWriter(nombreArchivo);
             BufferedWriter bw = new BufferedWriter(fw)) {

            // Escritura de la información dentro del archivo
            bw.write("Información del Curso de Programación Orientada a Objetos");
            bw.newLine(); // Inserta un salto de línea limpio
            bw.write("Estado: Datos guardados correctamente.");
            bw.newLine();
            bw.write("Actividad de gestión de archivos finalizada.");

            System.out.println("Los datos se han guardaron con éxito en: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
