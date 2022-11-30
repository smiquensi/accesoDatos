/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package escribirdom;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.File;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author santimiquel
 */
public class EscribirDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String titulo = "Dune";
        String ano = "2021";
        String duracion = "155";
        String actor = "Timothée Chalamet";

        DocumentBuilderFactory factoria = DocumentBuilderFactory.newDefaultInstance();
        try {
            DocumentBuilder builder = factoria.newDocumentBuilder(); // esto se mantiene en lectura y escritura de DOM
            Document documento = (Document) builder.parse(new File("pelis.xml"));

            // Elegimos el nodo peli y añadimos atribujos hijo
            Element raiz = documento.createElement("peli");
            documento.getDocumentElement().appendChild(raiz);

            // añadimos los atributos
            crearElemento("titulo", titulo, raiz, documento);
            crearElemento("ano", ano, raiz, documento);
            crearElemento("duracion", duracion, raiz, documento);
            crearElemento("actor", actor, raiz, documento);

            Source fuente = new DOMSource(documento);
            Result resultado = new StreamResult(new java.io.File("pelis.xml"));
            Transformer trasnformador = TransformerFactory.newDefaultInstance().newTransformer();
            trasnformador.transform(fuente, resultado);

            Result consola = new StreamResult(System.out);
            trasnformador.transform(fuente, resultado);

            // mostramos el contenido del documento
            NodeList pelis = documento.getElementsByTagName("peli");
            
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
            System.out.println("No se ha encontrado el archivo");
            e.printStackTrace();
        }

    }

    static void crearElemento(String campoemple, String valor, Element raiz, Document documento) {
        Element elem = documento.createElement(campoemple); // creamos hijo 
        Text texto = documento.createTextNode(valor); // damos valor 
        raiz.appendChild(elem); // pegamos el elemento hijo a la raíz
        elem.appendChild(texto); // pegamos el valor 

    }

    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
}
