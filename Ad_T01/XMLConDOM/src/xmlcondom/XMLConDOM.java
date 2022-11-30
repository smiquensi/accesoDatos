package xmlcondom;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.File;

/**
 *
 * @author santimiquel
 */
public class XMLConDOM {

    public static void main(String[] args) {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newDefaultInstance();
        try {
            DocumentBuilder builder = factoria.newDocumentBuilder();
            Document documento = builder.parse(new File("datos/pelis.xml"));
            documento.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + documento.getDocumentElement().getNodeName() + "\n");
            
            // Crea una lista con todos los nodos pelis
            NodeList pelis = documento.getElementsByTagName("peli");
            // Recorremos el nodeList     
            for (int i = 0; i < pelis.getLength(); i++) {
                Node pel = pelis.item(i);

                Element elemento = (Element) pel; // Obtenemos el elmento del nodo
                System.out.println("Titulo: " + getNodo("titulo", elemento));
                System.out.println("Ano: " + getNodo("ano", elemento));
                System.out.println("Duración: " + getNodo("duracion", elemento));
                System.out.println("Actor: " + getNodo("actor", elemento));
                System.out.println("******************************");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }

}
