package cajExecuteService;
import static java.lang.Thread.sleep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal{
	public static void main (String arg[]){
		
		long ti=System.currentTimeMillis(); 

		int numClientes=10;
                int numCajeras=3;
                
                Clientes listClientes[] = new Clientes[numClientes];  
                
		for(int i=0;i<numClientes;i++){
			
			int cant = (int) (Math.random() * 5) + 1;
			int numeros[] = new int[cant];
			for(int j=0;j<cant;j++){
				numeros[j]=(int) (Math.random() * 20) + 1;
			}
			
			listClientes[i] = new Clientes("CLIENTE "+i,numeros);
		}
		
		//Declarar el executor con el numero de hilos disponibles simultaneamente
		ExecutorService es = Executors.newFixedThreadPool(numCajeras);
                
		//Proceso de llenado, indicar cuantos hilos totales se deben lanzar
		for(int i=0;i<listClientes.length;i++){
			Cajeras caj = new Cajeras("CAJ"+i, listClientes[i]);
			es.execute(caj);
		}

		//Indicamos que ya se han añadido todos los hilos que se desean ejecutar
		es.shutdown();
		
		//Mantenemos el programa en ejecución mientras queden hilos por ejecutar
		while(!es.isTerminated()){
		
		}

		long tf=(System.currentTimeMillis()-ti)/1000;
		System.out.println("\n*** Todos los carritos procesados, tiempo total "+tf+"s.");
	}
}