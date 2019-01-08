import javax.swing.SwingConstants

object Hola {
  def main(args: Array[String]):Unit = {
    /*println("introduce un numero")
    val numero = io.StdIn.readInt()
    salida(numero)*/
      // creacion del array
    val array = new Array[Int](10)
    var lista = List.tabulate(10)(num => "boniato")
    lista ::= "patata"
    lista ::= "mariano"
    // creacion de un bucle for
    // i <- 1 to 10 combierte a i en un iterable
    for(i <- 0 to array.length-1){
      array(i) = i+1
    }
    for(i <- array){
      println(i)
    }
    for(i <- lista){
      println(i)
    }

  }
  // metodo que define la salida
  def salida(numero: Int): Unit ={
    if(numero > 0) Console.println(s"${Console.RESET}${Console.GREEN} ${numero} es un numero guay${Console.RESET}")
    else Console.println(s"{RESET}${Console.RED} ${numero} es un numero chafa${Console.RED}")
  }
}
