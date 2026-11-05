# Guiaape51raparte1
Realizar 3 ejercicios con lo aprendido en clase
# 🚀 Ejercicios APE - Manejo de Archivos en Java

![Java](https://shields.io)
![POO](https://shields.io)

Este repositorio contiene las soluciones de código en **Java** para las actividades de la **Actividad Práctica Experimental (APE)**. Los ejercicios están enfocados en la persistencia de datos local, la manipulación de archivos (`java.io`) y el control estructurado de excepciones mediante bloques `try-catch`.

---

## 📁 Contenido del Proyecto

El repositorio está dividido en tres componentes principales que abarcan el ciclo de vida completo de un archivo de texto (`.txt`):

```text
├── src/
│   ├── CrearArchivo.java      # Ejercicio 1: Instanciación y creación física
│   ├── EscribirArchivo.java   # Ejercicio 2: Entrada por teclado y modo append
│   └── EliminarArchivo.java   # Ejercicio 3: Control y remoción de ficheros
└── README.md
```

---

## 🛠️ Ejercicios Resueltos

### 🔹 Ejercicio 1: Crear un Fichero en Java
**Enunciado:** Desarrollar un programa que permita comprobar y crear físicamente un archivo de texto llamado `curso.txt` en la raíz del proyecto.

* **Clases clave:** `File`, `IOException`
* **Métodos principales:** `createNewFile()`, `getName()`

```java
import java.io.File; 
import java.io.IOException; 

public class CrearArchivo { 
    public static void main(String[] args) { 
        File archivo = new File("curso.txt"); 
        
        try { 
            if (archivo.createNewFile()) { 
                System.out.println("El archivo se creó correctamente."); 
            } else { 
                System.out.println("El archivo no se pudo crear porque ya existe."); 
            } 
            System.out.println("Nombre del archivo: " + archivo.getName()); 
            
        } catch (IOException e) { 
            System.out.println("Ocurrió un error al intentar crear el archivo."); 
            e.printStackTrace(); 
        } 
    } 
}
```

---

### 🔹 Ejercicio 2: Escribir Información en un Fichero
**Enunciado:** Desarrollar un programa que capture un mensaje por teclado y lo almacene al final de un archivo existente llamado `estudiantes.txt` sin borrar los datos previos (Modo Append).

* **Clases clave:** `Scanner`, `FileWriter`
* **Métodos principales:** `write()`, `close()`, `System.lineSeparator()`

```java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirArchivo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Ingrese un mensaje: ");
        String mensaje = teclado.nextLine();
        
        try {
            // El parámetro 'true' habilita la persistencia acumulativa
            FileWriter escritor = new FileWriter("estudiantes.txt", true);
            escritor.write(mensaje + System.lineSeparator());
            escritor.close();
            System.out.println("La información se guardó correctamente.");
            
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo.");
            e.printStackTrace();
        }
        
        teclado.close();
    }
}
```

---

### 🔹 Ejercicio 3: Eliminar un Fichero en Java
**Enunciado:** Desarrollar un programa estructurado que intente remover permanentemente el archivo `estudiantes.txt` evaluando el resultado de la operación.

* **Clases clave:** `File`
* **Métodos principales:** `delete()`

```java
import java.io.File;

public class EliminarArchivo {
    public static void main(String[] args) {
        File archivo = new File("estudiantes.txt");
        
        if (archivo.delete()) {
            System.out.println("El archivo 'estudiantes.txt' se eliminó correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo. Verifique si existe o si está bloqueado.");
        }
    }
}
```

---

## 🚀 Instrucciones de Ejecución

Si deseas clonar y probar estos archivos de forma local desde tu terminal:

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com
   cd nombre-del-repositorio
   ```

2. **Compila cualquiera de los archivos:**
   ```bash
   javac CrearArchivo.java
   ```

3. **Ejecuta el programa compilado:**
   ```bash
   java CrearArchivo
   ```

---

## 🧠 Conceptos POO Aprendidos
* **Flujos de Datos (I/O):** Interacción directa con el sistema de archivos del sistema operativo mediante streams.
* **Modo Append:** Uso del booleano `true` en el constructor de `FileWriter` para añadir registros de texto de forma acumulativa sin sobreescribir datos pasados.
* **Checked Exceptions:** Gestión e interceptación obligatoria de errores con `try-catch` para controlar eventos de hardware/permisos fuera del control de la JVM.
