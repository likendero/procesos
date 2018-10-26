/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoaceso;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *  primera pruba para el rapaso, crear un archivo con dom
 * @author likendero
 */
public class RepasoAceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document documento;
        
        try{
            // creacion del parser
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            // creacion del decumento que se va crear
            DOMImplementation implementacion = builder.getDOMImplementation();
            // creacion del documento
            documento = implementacion.createDocument(null, "personas", null);
            documento.setXmlVersion("1.0");
            // crear elemento
            Element elemento = documento.createElement("persona");
            // annadir atributo
            elemento.setAttribute("DNI", "76661780c");
            // desplzarse hasta el elemento
            documento.getDocumentElement().appendChild(elemento);
            // creacion de los elementos
            Element nombre = documento.createElement("nombre");
            Element primerApellido = documento.createElement("primer_apellido");
            Element segundoApellido = documento.createElement("segundo_apellido");
            Element estado = documento.createElement("estado");
            // annadiendo elementos
            elemento.appendChild(nombre);
            elemento.appendChild(primerApellido);
            elemento.appendChild(segundoApellido);
            elemento.appendChild(estado);
            // creacion valores
            Text txNombre = documento.createTextNode("Javier");
            Text txApellido = documento.createTextNode("Gonzalez");
            Text txSegundoApellido = documento.createTextNode("Rives");
            Text txEstado = documento.createTextNode("con pareja");
            // vinculado
            nombre.appendChild(txNombre);
            primerApellido.appendChild(txApellido);
            segundoApellido.appendChild(txSegundoApellido);
            estado.appendChild(txEstado);
            
            // creacion del fichero
            
            Source source = new DOMSource(documento);
            
            Result result = new StreamResult(new File("/home/likendero/prueba/persona.xml"));
            TransformerFactory traF = TransformerFactory.newInstance();
            Transformer trans = traF.newTransformer();
            trans.transform(source, result);
        }catch(DOMException dom){
        
        } catch (ParserConfigurationException ex) {
           // Logger.getLogger(RepasoAceso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
          //  Logger.getLogger(RepasoAceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
