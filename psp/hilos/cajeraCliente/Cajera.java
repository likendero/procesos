package cajeraCliente;
import java.lang.Thread;

import cajeraCliente.Clientes;


public class Cajera extends Thread
{
    private Clientes cliente;
    /**
     * constructor que se crea con un cliente por paramentro
     * @param cliente
     */
    public Cajera(Clientes cliente)
    {
        super();
        this.cliente = cliente;
    }
    /**
     * este metodo procesa la compra de un cliente
     */
    public void atenderCliente()
    {
        long tiempoIncial = System.currentTimeMillis();
        // recorrido de la compra del cliente
        for(int i = 0; i < cliente.getCarritoCli().length ; i++)
        {
            // se muestra por pantalla de quien y que articulo
            System.out.println("articulo " + (i+1) + " de " + cliente.getNombreCli());
            // se procesa con su correspondiente tiempo
            procesamiento(cliente.getCarritoCli()[i]);
        }
        // calculo del timepo final
        long tiempoFinal = (System.currentTimeMillis()-tiempoIncial)/1000;
        // salida del tiempo final
        System.out.println("el timepo de procesamiento de " + cliente.getNombreCli() + " es de " 
        + tiempoFinal + "s"
        );
    }
    /**
     * procesamiento del cliente
     * @param tiempo tiempo es segundos que se tarda en procesar la compra
     */
    public void procesamiento(int tiempo)
    {
        // control que se hace bien la espera
        try
        {
            
            // cada 1000 milisegundos es un segundo
            Thread.sleep(tiempo*1000);
        }
        // caso que se interrumpa la espera
        catch(InterruptedException it)
        {
            System.out.println("error el tiempo se ha interrumpido");
            it.printStackTrace();
        }
        // caso que el paramentro sea incorrecto
        catch(IllegalArgumentException il)
        {
            System.out.println("los argumentos introducidos no son validos");
        }
    }
    /**
     * metodo cambia cliente de la cajera
     * @param cliente
     */
    public void setCliente(Clientes cliente)
    {
        this.cliente = cliente;
    }
    @Override
    public void run() {
        super.run();
        this.atenderCliente();
    }
}