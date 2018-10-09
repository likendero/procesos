/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.albaran;

import generated.Direccion;
import generated.PedidoType;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author linuxdiurno
 */
public class JaxbAlbaran {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            File dir = new File("/home/linuxdiurno/github/smartgit/AccesoDatos/filez/Scripts/albaran.xml");
            // instancia de manipulacion
            JAXBContext cont = JAXBContext.newInstance("generated");
            // des serializar
            Unmarshaller u = cont.createUnmarshaller();
            
            // generacion del element
            JAXBElement Element = (JAXBElement) u.unmarshal(new FileInputStream(dir));
            // generacion del tipo pedido
            PedidoType pedido = (PedidoType) Element.getValue();
            // creacion de la direccion
            Direccion direc = pedido.getFacturarA();
            // cambio de valores
            direc.setNombre("Javier Gonzalez");
            direc.setCalle("gibrealtar");
            direc.setCiudad("Almeria");
            direc.setProvincia("Murcia");
            direc.setCodigoPostal(new BigDecimal("04007"));
            
            Marshaller m = cont.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        }catch(Exception ex){
            
        }
    }
    
}
