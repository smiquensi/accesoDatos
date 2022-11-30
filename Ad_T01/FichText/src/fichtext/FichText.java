/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fichtext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author santimiquel
 */
public class FichText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dir = "FICHTEXT";
        File f = new File(dir);
        File archivoTxt = new File(f, "FichText.txt");
        String textoMuestra = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin cursus congue. Ut odio mi, sodales at condimentum semper, aliquet in diam. In varius sollicitudin nibh at auctor. Aenean fermentum magna purus, quis porta elit iaculis vitae. Integer consequat sapien vel maximus aliquet. In odio dolor, rutrum in elementum vitae, ullamcorper at tellus. Sed sit amet ipsum convallis, hendrerit nisl et, gravida felis. Sed hendrerit cursus justo, nec venenatis arcu maximus et. Fusce feugiat turpis eu elit convallis dignissim vel quis elit. Sed ligula tortor, congue ultrices commodo nec, vulputate maximus purus. Nulla hendrerit nunc ut mi porta faucibus. Nam tempor diam convallis elit congue, ac tristique odio scelerisque. Cras imperdiet pulvinar dui at venenatis. Sed viverra gravida augue in blandit.";
        char[] texto_a_char = new char[textoMuestra.length()];

        f.mkdir();
        
        try {
            archivoTxt.createNewFile();
            FileWriter fw = new FileWriter("./FICHTEXT/FichTExt.txt");
            for (int i = 0; i < textoMuestra.length(); i++) {
                texto_a_char[i]=textoMuestra.charAt(i);
                fw.write(texto_a_char[i]);
            }
            
            fw.close();
            System.out.println("Texto añadido al archivo con exito.");

        } catch (IOException e) {
            System.out.println("El disco duro esta lleno o protegido frente a escritura");
        }

    }

}
