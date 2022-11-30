/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leerfichtextobuf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author santimiquel
 */
public class LeerFichTextoBuf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader fichero = new BufferedReader(new FileReader("/Users/santimiquel/www/accesoDatos/Ad_T01/LeerFichTexto/fichTexto/fichTexto.txt"));
            String linea;
            while ((linea = fichero.readLine()) != null) {
                System.out.println(linea);
                fichero.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra");
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        }
    }

}
