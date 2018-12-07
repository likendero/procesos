package cajExecuteService;

public class Cajeras extends Thread{
	private Clientes cli;
	
	//---------------- CONSTRUCTORES -----------------------------
	
	public Cajeras(){	
	}
	
	public Cajeras(String n, Clientes cliente){
		super(n); 
		cli=cliente;
	}
	
	//-------------------------------------------------------------
	
	@Override
    public void run(){
		long ti=System.currentTimeMillis(); 
		
		System.out.println("---- CAJERA "+ getName() +" PROCESANDO CARRITO DE "+cli.getNombreCli()+" ----"); 
		int carrito[]= cli.getCarritoCli();
		for(int i=0; i<carrito.length;i++){
			System.out.println("-> Articulo "+(i+1)+" ("+carrito[i]+"s).");
			try {
				sleep((long) carrito[i]*1000);
			} catch (Exception ex){
			}
		}
		
		long tf=(System.currentTimeMillis()-ti)/1000;
		
		System.out.println("---- CARRITO DE "+cli.getNombreCli()+" PROCESADO, TIEMPO "+tf+"s ----");
	}
}