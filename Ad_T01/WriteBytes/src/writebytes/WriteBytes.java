package writebytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author santimiquel
 */
public class WriteBytes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crea un programa que escriba bytes en un fichero y después los visualice.
        File f = new File(".", "archivoBinario");
        String datos = "Introduciendo datos en el archivo.";
        byte b[] = datos.getBytes();
        try {
            f.createNewFile();
            // Introduciendo datos en archivo
            FileOutputStream fos = new FileOutputStream("archivoBinario");
            fos.write(b);
            fos.close();
            
            // Leyendo datos del archivo
            FileInputStream fis = new FileInputStream("archivoBinario");           
            int i = 0;
            while ((i=fis.read())!=-1) {                
                System.out.print((char)i);
            }
            System.out.println("");
            fis.close();
                       
        } catch (Exception e) {
            System.out.println("Error E/S");
        }
    }

}
