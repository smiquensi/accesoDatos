package readbytes;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadBytes {

    public static void main(String[] args) {
        try {
            // Cada linea me ocupa 62
            RandomAccessFile readFile = new RandomAccessFile("empleados.data", "r");
            // Creo un array de char para almacenar los textos
            char[] arrayChar = new char[62];
            // Recorro el documento linea por linea, almaceno cada linea en en 
            // el array, busco en la posicion 4 de cada linea. En caso de que la
            // posicion 4 sea igual a 5, se imprirá esa linea por pantalla.
            for (int i = 0; i < readFile.length(); i += 62) {
                readFile.seek(i);
                arrayChar = readFile.readLine().toCharArray();
                if (arrayChar[4]  == '5') {
                    System.out.println(arrayChar);
                }
            }
            readFile.close();
        } catch (IOException e) {
            System.out.println("Error E/S");
        }
    }
}
