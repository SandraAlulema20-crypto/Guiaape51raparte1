import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        // El segundo parámetro "true" activa el modo append (no borra lo anterior)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("productos.txt", true))) {
            do {
                System.out.print("Nombre del producto: ");
                String nombre = sc.nextLine();

                System.out.print("Precio: ");
                double precio = Double.parseDouble(sc.nextLine().replace(',', '.'));

                System.out.print("Cantidad disponible: ");
                int cantidad = Integer.parseInt(sc.nextLine());

                double total = precio * cantidad;

                bw.write("Producto: " + nombre);
                bw.newLine();
                bw.write("Precio: $" + String.format(java.util.Locale.US, "%.2f", precio));
                bw.newLine();
                bw.write("Cantidad: " + cantidad);
                bw.newLine();
                bw.write("Valor total: $" + String.format(java.util.Locale.US, "%.2f", total));
                bw.newLine();
                bw.write("------------------------");
                bw.newLine();

                System.out.println("Valor total: $" + String.format(java.util.Locale.US, "%.2f", total));
                System.out.print("¿Registrar otro producto? (s/n): ");
                continuar = sc.nextLine();
            } while (continuar.equalsIgnoreCase("s"));

            System.out.println("Productos guardados en productos.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: ingresó un número inválido.");
        }

        sc.close();
    }
}
