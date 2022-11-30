package modificardom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.*;

/**
 *
 * @author santimiquel
 */
public class ModificarDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factoria.newDocumentBuilder();
            Document documento = builder.parse(new File("pelis.xml"));

            XPath cadenaXPath = XPathFactory.newInstance().newXPath();

            String expr = "/pelis/peli[duracion > 150]/actor";

            //Crea una lista con todos los nodos id de los empleados que cumplen la condición 
            NodeList masDe150 = (NodeList) cadenaXPath.compile(expr).evaluate(documento, XPathConstants.NODESET);
            //Recorremos la lista obtenida par visualizar el id del empleado 
            for (int i = 0; i < masDe150.getLength(); i++) {

                Node actor = masDe150.item(i);
                actor.setTextContent("Santi Miquel");

                Source fuente = new DOMSource(documento);
                Result resultado = new StreamResult(new java.io.File("pelis.xml"));
                Transformer transformador = TransformerFactory.newInstance().newTransformer();
                transformador.transform(fuente, resultado);

                Result consola = new StreamResult(System.out);
                transformador.transform(fuente, consola);
            }

        } catch (Exception e) {
        }

    }

}
