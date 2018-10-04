package cajeraCliente;

public class Clientes{
    private String nombreCli;
    private int[] carritoCli;

    public Clientes(String n, int[] c){
        nombreCli = n;
        carritoCli = c;
    }
    public Clientes(){

    }
    /**
     * de finir nombre
     * @param nombre
     */
    public void setNombreCli(String nombre){
        this.nombreCli = nombre;
    }
    /**
     * metodo para definir el carrito del cliente
     * @param carrito
     */
    public void setCarrito(int[] carrito){
        this.carritoCli = new int[carrito.length];
        for(int i = 0; i < carrito.length; i++){
            this.carritoCli[i] = carrito[i];
        }
    }
    /**
     * metodo que devuelve el nombre del cliente
     * @return
     */
    public String getNombreCli(){
        return this.nombreCli;
    }
    /**
     * metodo qeu devuelve el carrito del cliente
     * @return
     */
    public int[] getCarritoCli(){
        return this.carritoCli;
    }
}