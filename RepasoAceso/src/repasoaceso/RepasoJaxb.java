/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoaceso;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import albaranJaxb.Articulos;
import albaranJaxb.PedidoType;
import javax.xml.bind.Marshaller;

/**
 *
 * @author likendero
 */
public class RepasoJaxb {
    public static void main(String[] args) {
        try{
            JAXBContext contex = JAXBContext.newInstance("albaranJaxb");
            Unmarshaller unmar = contex.createUnmarshaller();
            JAXBElement element = (JAXBElement) unmar.unmarshal(new File("/home/likendero/albaranp.xml"));
            PedidoType pedido = (PedidoType) element.getValue();
            Articulos articulos = pedido.getArticulos();
            Articulos.Articulo articulo = articulos.getArticulo().get(0);
            
           // mostrar articulos
            System.out.println("Nombre de producto: " + articulo.getNombreProducto());
            System.out.println("comentario: " + articulo.getComentario());
            System.out.println("codigo del producto: " + articulo.getCodigo());
            articulo.setCantidad(22);
            articulo.setCodigo("hola que tal");
            articulo.setComentario("el jaxb me la come doblada");
            
            Marshaller mar = contex.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(element, new File("/home/likendero/albaranp.xml"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
