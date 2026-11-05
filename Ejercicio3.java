import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalAcumulado = 0;

        // Modo append para no eliminar registros anteriores
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ventas.txt", true))) {
            while (true) {
                System.out.print("Nombre del producto (escriba 'fin' para terminar): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }

                System.out.print("Precio: ");
                double precio = Double.parseDouble(sc.nextLine().replace(',', '.'));

                System.out.print("Cantidad vendida: ");
                int cantidad = Integer.parseInt(sc.nextLine());

                double subtotal = precio * cantidad;
                double descuento = 0;

                if (subtotal >= 100) {
                    descuento = subtotal * 0.10;
                }

                double totalPagar = subtotal - descuento;
                totalAcumulado += totalPagar;

                System.out.println("Subtotal: $" + String.format(Locale.US, "%.2f", subtotal));
                System.out.println("Descuento: $" + String.format(Locale.US, "%.2f", descuento));
                System.out.println("Total a pagar: $" + String.format(Locale.US, "%.2f", totalPagar));
                System.out.println();

                bw.write("Producto: " + nombre);
                bw.newLine();
                bw.write("Precio: $" + String.format(Locale.US, "%.2f", precio)
                        + " | Cantidad: " + cantidad);
                bw.newLine();
                bw.write("Subtotal: $" + String.format(Locale.US, "%.2f", subtotal)
                        + " | Descuento: $" + String.format(Locale.US, "%.2f", descuento));
                bw.newLine();
                bw.write("Total a pagar: $" + String.format(Locale.US, "%.2f", totalPagar));
                bw.newLine();
                bw.write("------------------------");
                bw.newLine();
            }

            // Al finalizar, se guarda el total acumulado
            bw.write("TOTAL ACUMULADO DE VENTAS: $" + String.format(Locale.US, "%.2f", totalAcumulado));
            bw.newLine();
            bw.write("========================");
            bw.newLine();

            System.out.println("Total acumulado: $" + String.format(Locale.US, "%.2f", totalAcumulado));
            System.out.println("Ventas guardadas en ventas.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: ingresó un número inválido.");
        }

        sc.close();
    }
}
