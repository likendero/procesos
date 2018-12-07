package cajExecuteService;

public class Clientes{
	private String nombreCli;
	private int carritoCli[];
	
	//--------------------------------------------------
	public Clientes (String n, int [] c){
		nombreCli = n;
		carritoCli = c;
	}
	
	public Clientes(){
		
	}	
	//------------------- GETTERS Y SETTERS -------------------------------
	public void setNombreCli(String n){
		nombreCli=n;
	}
	
	public String getNombreCli(){
		return nombreCli;
	}
	
	public void setCarritoCli(int c[]){
		//setCarrito=c;
	}
	
	public int[] getCarritoCli(){
		return carritoCli;
	}
}