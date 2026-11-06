import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio8 {
    public static void main(String[] args) {
        String[] materias = {
            "Algoritmos y Lógica de Programación",
            "Cálculo Diferencial",
            "Física",
            "Matemática Discreta",
            "Comunicación Oral y Escrita"
        };

        BufferedWriter bw = null;
        try {
            // 1. BufferedWriter enlazado con FileWriter (modo sobrescribir)
            bw = new BufferedWriter(new FileWriter("materias.txt"));

            // 2 y 3. Escribir cada asignatura y salto de línea portable
            for (String materia : materias) {
                bw.write(materia);
                bw.newLine();
            }
            System.out.println("Archivo materias.txt generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        } finally {
            // 4. Liberar recursos
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