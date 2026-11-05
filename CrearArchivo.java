import java.io.File; 
import java.io.IOException; 

public class CrearArchivo { 
    public static void main(String[] args) { 
        // Se agregaron las comillas a "curso.txt"
        File archivo = new File("curso.txt"); 
        
        try { 
            // Intenta crear el archivo en el disco
            if (archivo.createNewFile()) { 
                System.out.println("Archivo creado correctamente."); 
            } else { 
                System.out.println("El archivo ya existe."); 
            } 
            System.out.println("Nombre del archivo: " + archivo.getName()); 
            
        } catch (IOException e) { 
            System.out.println("Ocurrió un error al crear el archivo."); 
            e.printStackTrace(); 
        } 
    } 
}
