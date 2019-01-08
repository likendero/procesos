
package Ejercicio3;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Cuba {
    // el maximo de litros es 1000
    public static int litros = 300;
    /**
     * metodo en el que la empresa y los jardineros realizan su proceso
     */
    public synchronized static void estaCubaRevolucionaria(Object objeto){
        // en el caso que este actuando la empresa y falten litros
        if(objeto instanceof Llenado && litros < 1000){
            llenado();
        }
        // en el caso que actue el jardinero y halla litros
        if(objeto instanceof Jardinero && litros > 0){
            vaciado();
        }
        System.out.println("litros finales: " + litros);
    }
    /**
     * metodo que realiza el llenado
     */
    private static void llenado(){
        int tiempo = (int)(Math.random()*4+1);
        for(int i = 0; i < tiempo; i++){
            // con esta variable guardo los litros antes de añadir
            int litrosAux = litros;
            // añado los litros de agua necesarios
            litros += 150;
            // tiempo de espera
            try{
                Thread.sleep(1000);
            }catch(InterruptedException in){}
            // compopruebo que los litros no se pasen
             if(litros > 1000){
                 // si se pasa el valor se cambia la maximo
                litros = 1000;
                // y el contador se cambia al tiempo
                i = tiempo;
            }
            // calculo el numero de litros añadidos restandole a los actuales
            // los litros anteriores
            System.out.println("la empresa ha añadido " + (litros-litrosAux) + " litros de agua"); 
        }
        
    }
    /**
     * metodo que realiza el vaciado
     */
    private static void vaciado(){
        int tiempo = (int)(Math.random()*4+2);
        for(int i = 0; i < tiempo; i++){
            // con esta variable guardo los litros antes de añadir
            int litrosAux = litros;
            // añado los litros de agua necesarios
            litros -=100;
            // tiempo de espera
            try{
                Thread.sleep(1000);
            }catch(InterruptedException in){}
            // compopruebo que los litros no se pasen
             if(litros <= 0){
                 // si se pasa el valor se cambia la minimo
                litros = 0;
                // y el contador se cambia al tiempo
                i = tiempo;
            }
            // calculo el numero de litros añadidos restandole a los actuales
            // los litros anteriores
            System.out.println("el Jardinero ha quitado " + -(litros-litrosAux) + " litros de agua"); 
        }
        
    }
}
