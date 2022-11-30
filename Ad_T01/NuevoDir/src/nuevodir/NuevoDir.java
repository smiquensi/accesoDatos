/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nuevodir;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author santimiquel
 */
public class NuevoDir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
        ACTIVIDAD 2
        Crea un directorio (de nombre NUEVODIR) en el directorio actual, 
        a continuación crea dos ficheros vacíos en dicho directorio y uno de 
        ellos lo renombras.
        */
        String newDir = "NUEVODIR";
        File f = new File(newDir);
        // Creamos el directorio
        f.mkdir();
        
        File archivo1 = new File(f, "fichero1.txt");
        File archivo2 = new File(f, "fichero2.txt");
        File archivoCambiado = new File(f, "archivoNombreCambiado.txt");
        
        // Creamos los archivos
        archivo1.createNewFile();
        archivo2.createNewFile();
        
        // Renombramos un archivo.
        archivo2.renameTo(archivoCambiado);
        
        /* 
        ACTIVIDAD 3
        Borra el directorio creado anteriormente. 
        a) ¿Qué ocurre? ¿Por qué?
        b) ¿Cómo se puede solucionar? Escribe el código correcto.
        */
        
        // a) Este metodo no borra el directorio actual, porque el directorio 
        // contiene archivos, si el directorio estuviera vacio si lo borraría.
        f.delete(); 

        
        // b) Comprobamos que el directorio no está vacio, primero borramos los 
        // archivo y despues el directorio.
        File[] todoContenido = f.listFiles();
        if (todoContenido != null) {
            for (File file : todoContenido) {
                file.delete();
            }
            
        }
        f.delete();
    }
    
}
