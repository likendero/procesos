package lavadero;
enum Tamanno{
    PEQUENNO(10),
    MEDIANO(14),
    GRANDE(18);

    private int tiempo;
    Tamanno(int tiempo){
        this.tiempo = tiempo;
    }
    public int getTiempo(){return tiempo;}
}