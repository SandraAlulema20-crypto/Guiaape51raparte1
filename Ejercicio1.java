import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // try-with-resources: cierra el archivo automáticamente
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Estudiante " + i);
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Calificación: ");
                String calificacion = sc.nextLine();

                // Cada estudiante ocupa dos líneas: nombre y calificación
                bw.write(nombre);
                bw.newLine();
                bw.write(calificacion);
                bw.newLine();
            }
            System.out.println("Datos guardados en estudiantes.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
