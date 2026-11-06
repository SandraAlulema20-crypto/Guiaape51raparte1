import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio9 {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            // 1. Segundo parámetro en true = modo adición (append)
            bw = new BufferedWriter(new FileWriter("materias.txt", true));

            // 2. Añadir dos nuevas asignaturas al final
            bw.write("Química");
            bw.newLine();
            bw.write("Programación Orientada a Objetos");
            bw.newLine();

            System.out.println("Asignaturas añadidas al final de materias.txt.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        } finally {
            // 3. Cerrar el flujo
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}