/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package write5lines;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author santimiquel
 */
public class Write5Lines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea un programa que escriba 5 filas de caracteres en un fichero de texto 
        // y después de escribir cada fila, que salte una línea (método newLine().
        String txtMuestra = "Lorem ipsum dolor sit ame.";
        File f = new File("ARCHIVOTXT");
        File archivoTxt = new File(f,"archivoTxt.txt");

        f.mkdir();
        try {
            archivoTxt.createNewFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTxt))) {
                for (int i = 0; i < 5; i++) {
                    bw.write(txtMuestra);
                    bw.newLine();
                }
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Error E/S");
        }
    }

}
