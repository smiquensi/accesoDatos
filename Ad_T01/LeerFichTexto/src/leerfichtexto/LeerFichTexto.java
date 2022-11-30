/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leerfichtexto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santimiquel
 */
public class LeerFichTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        File f = new File("./fichTexto/fichTexto.txt");
        
        try {
            FileReader fr = new FileReader(f);
            
            char[] charArray = new char[850];
            
            fr.read(charArray);

            for (char caracteres : charArray) {
                System.out.print(caracteres);   
            }
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe o no es valido");
        }catch (IOException ex) {
            System.out.println("Error de disco lleno o falta de permisos");
        }

    }

}

//import java.io.*;
//public class FileRead {
//
//   public static void main(String args[])throws IOException {
//      File file = new File("Hello1.txt");
//      
//      // creates the file
//      file.createNewFile();
//      
//      // creates a FileWriter Object
//      FileWriter writer = new FileWriter(file); 
//      
//      // Writes the content to the file
//      writer.write("This\n is\n an\n example\n"); 
//      writer.flush();
//      writer.close();
//
//      // Creates a FileReader Object
//      FileReader fr = new FileReader(file); 
//      char [] a = new char[50];
//      fr.read(a);   // reads the content to the array
//      
//      for(char c : a)
//         System.out.print(c);   // prints the characters one by one
//      fr.close();
//   }
//}
