import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirArchivo {
    public static void main(String[] args) {
        // 1. Crear un objeto Scanner para ingresar información por teclado
        Scanner teclado = new Scanner(System.in);
        
        // 2. Solicitar al usuario que escriba un mensaje
        System.out.print("Ingrese un mensaje: ");
        String mensaje = teclado.nextLine();
        
        // 3. Controlar posibles errores mediante try-catch
        try {
            // 4. Utilizar FileWriter para abrir el archivo estudiantes.txt 
            // 5. Utilizar el parámetro true para conservar la información anterior (modo append)
            FileWriter escritor = new FileWriter("estudiantes.txt", true);
            
            // 6. Utilizar el método write() para guardar el mensaje junto con un salto de línea
            escritor.write(mensaje + System.lineSeparator());
            
            // 7. Cerrar el archivo utilizando close()
            escritor.close();
            
            // 8. Mostrar un mensaje indicando que la información se guardó correctamente
            System.out.println("La información se guardó correctamente.");
            
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo.");
            e.printStackTrace();
        }
        
        // Cerrar el objeto Scanner
        teclado.close();
    }
}
