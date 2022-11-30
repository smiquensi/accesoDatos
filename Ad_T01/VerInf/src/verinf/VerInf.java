/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package verinf;

import java.io.*;

/**
 *
 * @author santimiquel
 */
public class VerInf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("INFORMACIÓN SOBRE EL FICHERO: ");
        
//        File f = new File (“D: \\ADAT\\UNI1\\VerInf.java”); // OS Windows
        File f = new File("/Users/santimiquel/www/accesoDatos/Ad_T01/VerInf");
        if (f.exists()) {
            System.out.println("Nombre del fichero: " + f.getName());
            System.out.println("Ruta: " + f.getPath());
            System.out.println("Ruta absoluta: " + f.getAbsolutePath());
            System.out.println("Se puede leer: " + f.canRead());
            System.out.println("Se puede escribir: " + f.canWrite());
            System.out.println("Tamaño: " + f.length());
            System.out.println("Es un directorio: " + f.isDirectory());
            System.out.println("Es un fichero: " + f.isFile());
            System.out.println("Nombre del directorio padre: " + f.getParent());
        }
    }
    
}
