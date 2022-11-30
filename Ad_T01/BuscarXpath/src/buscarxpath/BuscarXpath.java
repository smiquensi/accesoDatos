package buscarxpath;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.*;

public class BuscarXpath {

    public static void main(String[] args) {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factoria.newDocumentBuilder();
            Document documento = builder.parse(new File("pelis.xml"));
            
            XPath cadenaXPath = XPathFactory.newInstance().newXPath();
            
            String expr="/pelis/peli[duracion > 120]/titulo";
            //Crea una lista con todos los nodos id de los empleados que cumplen la condición 
            NodeList masDe20 = (NodeList) cadenaXPath.compile(expr).evaluate(documento,XPathConstants.NODESET);
            //Recorremos la lista obtenida par visualizar el id del empleado 
            for (int i=0;i<masDe20.getLength();i++){
                System.out.println("Duracion: "+ masDe20.item(i).getTextContent()); }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    

