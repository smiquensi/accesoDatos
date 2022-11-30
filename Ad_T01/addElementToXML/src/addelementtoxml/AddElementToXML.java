/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package addelementtoxml;

import java.io.File;
import java.util.ArrayList;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;

/**
 *
 * @author santimiquel
 */
public class AddElementToXML {
    //  ATRIBUTOS
    private String rutaFichero, nombreDOM;
    private static Document document;
    private static DocumentBuilder builder;
    //  SE CREA CONSTRUCTOR CON Y SIN SOBRECARGA
//    public GestionFicheroXML(String rutaFichero, String nombreFichero) {
//        this.nombreDOM = (nombreFichero.contains(".xml") ? nombreFichero.substring(0, nombreFichero.indexOf(".")) : nombreFichero);
//        this.rutaFichero = rutaFichero;
//    }

    //  MÉTODO ENCARGADO DE COMPROBAR QUE EXISTE EL ARCHIVO
    public boolean existeFichero(){
        //  SE CARGA LA CLASE DE FILE
        File f = new File(this.rutaFichero);
        //  SI EL ARCHIVO EXISTE SIGUE CON LA EJECUCIÓN, EN CASO CONTRARIO MUESTRA ERROR
        if(f.exists()) {
            System.out.println("[INFO] - LOCALIZADO EL ARCHIVO " + nombreDOM + ".xml");
            return true;
        }else {
            System.err.println("[INFO] - NO SE PUDO LOCALIZAR EL ARCHIVO " + nombreDOM + ".xml");
            return false;
        }
    }
    //  MÉTODO SOBRECARGADO DE ESCRITURA (RECIBE ARRAYLIST DEL OBJETO)
    public boolean escribirFichero(ArrayList<animal> animales) {
        //  SI HAY ANIMALES QUE RELLENAR
        if(!animales.equals(null) && animales.size() > 0) {
            // COMO LA EJECUCIÓN DEL CÓDIGO PUEDE DEVOLVER ERRORES HAY QUE INSTANCIAR UN TRY-CATCH
            try {
                //  SI EXISTE EL ARCHIVO LO CONCATENA
                if(this.existeFichero()) {
                    //  SE INSTANCIA LO NECESARIO PARA LA ESCRITURA
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    builder = factory.newDocumentBuilder();
                    document = builder.parse(new java.io.File(this.rutaFichero));
                    document.getDocumentElement().normalize();
                    //  SE OBTIENE LA RAÍZ
                    Node root = document.getFirstChild();
                    for(animal an : animales) {
                        //  SE COMPRUEBA QUE EL ELEMENTO ES DE TIPO NODO
                        if(root.getNodeType() == Node.ELEMENT_NODE) {
                            //   NO PUEDEN EXISTIR 2 ANIMALES IGUALES, SI NO EXISTE (METODO QUE COMPRUEBA LEYENDO EL FICHERO SI EXISTE)
                            if(!existeAnimal(an)) {
                                //  ETIQUETA ANIMAL
                                Element itemNode = document.createElement("animal");
                                itemNode.setAttribute("id", String.valueOf(an.getId()));
                                //  ETIQUETA NOMBRE
                                Element itemName = document.createElement("nombre");
                                itemName.setAttribute("hadpreviousname", String.valueOf(an.isHadPreviousName()));
                                //  ETIQUETA ULTIMO NOMBRE
                                Element itemLName = document.createElement("lastname");
                                //  ETIQUETA ACTUAL NOMBRE
                                Element itemAName = document.createElement("actualname");
                                //  SE INTRODUCE EL VALOR DEL CONTENIDO DENTRO DE LAS ETIQUETAS HIJAS
                                Text lastName = document.createTextNode(String.valueOf(an.getLastName()));
                                Text actualName = document.createTextNode(String.valueOf(an.getActualName()));
                                //  SE AGREGAN VALORES
                                itemLName.appendChild(lastName);
                                itemAName.appendChild(actualName);                      
                                //  SE COLOCAN LOS HIJOS DENTRO DEL ATRIBUTOS
                                itemName.appendChild(itemLName);
                                itemName.appendChild(itemAName);
                                //  SE COLOCAN LOS HIJOS DENTRO DEL PADRE
                                itemNode.appendChild(itemName);
                                //  SE COLOCA EL PADRE DENTRO DE LA RAÍZ
                                root.appendChild(itemNode);
                            }
                        }
                        //  CUANDO SE TIENE TODA LA ESTRUCTURA XML EN LA MEMORIA SE PROCEDE A ESCRIBIRLO EN EL FICHERO. PARA ESTO SE USA LA LIBRERÍA TRANSFORM INDICANDO DONDE ESTÁ EL DOCUMENTO
                        Source source = new DOMSource(document);
                        //  SE PREPARA EL FICHERO EN EL SISTEMA DE ARCHIVOS
                        Result result = new StreamResult(new java.io.File(this.rutaFichero));
                        //  SE EMPLEA EL OBJETO TRANSFORMER
                        Transformer transformer = TransformerFactory.newInstance().newTransformer();
                        //  SE TOMA EL DOCUMENTO DE LA MEMORIA Y LO ESCRIBE EN EL FICHERO CON RESULT
                        transformer.transform(source, result);
                    }
                }
            }catch (Exception e) {
                System.err.println("[ERROR] - NO SE PUDO ESCRIBIR, RAZÓN: " + e.getMessage());
                return false;
            }
        }else {
            System.err.println("[ERROR] - NO SE PUDO ESCRIBIR, RAZÓN: NO HAY OBJETOS QUE ESCRIBIR");
        }
    }
}

