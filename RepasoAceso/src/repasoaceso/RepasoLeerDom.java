/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoaceso;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author likendero
 */
public class RepasoLeerDom {
    public static void main(String[] args) {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document doc;
        File dir = new File("/home/likendero/prueba/persona.xml");
        try{
            // isntanciacion del factory
            factory = DocumentBuilderFactory.newInstance();
            // creacion del builder
            builder = factory.newDocumentBuilder();
            // parseo del xml
            doc = builder.parse(dir);
            // "normalizacion"
            doc.getDocumentElement().normalize();
            // generacion de lista de nodos
            NodeList nodos = doc.getElementsByTagName("persona");
            // recorrido sobre los nodos del documento
            for(int i = 0; i < nodos.getLength(); i++){
                Node persona = nodos.item(i);
                if(persona.getNodeType() == Node.ELEMENT_NODE){
                    Element elemento = (Element)persona;
                    System.out.println("el dni es: " + elemento.getAttribute("DNI"));
                    System.out.println("nombre: " + getNode("nombre",elemento));
                    System.out.println("primer apellido: " + getNode("primer_apellido",elemento));
                    System.out.println("segundo apellido: " + getNode("segundo_apellido",elemento));
                    System.out.println("nombre: " + getNode("estado",elemento));
                    
                }
               
            }
            
        }catch(IOException io){
            io.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static String getNode(String tag,Element elem){
        NodeList nodos = elem.getElementsByTagName(tag).item(0).getChildNodes();
        Node nodoConValor = nodos.item(0);
        
        if(nodoConValor.getNodeType() == Node.TEXT_NODE){
            System.out.println("es un nodo texto");
        }
        return nodoConValor.getNodeValue();
    }
}
