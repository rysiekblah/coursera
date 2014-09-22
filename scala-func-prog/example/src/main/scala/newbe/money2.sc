def fun(money: Int, coins: List[Int]): Int = {

  def sumi(sum: Int, coin: Int): Int = {
    if(sum>=money) sum-coin else sumi(sum + coin, coin)
  }

  def calc(sumaa: Int, count: Int, coin: Int, rest: List[Int]): Int = {
    val suma = sumi(sumaa, coin)
    println(" --- *calc coin: " + coin + ", coins: " + rest + ", sum: " + suma)
    if(suma+coin == money) count+1 else
      if(rest.isEmpty) count else
      calc(suma, count, rest.head, rest.tail)

  }

  def loop(count: Int, coins: List[Int]): Int = {
    if(coins.isEmpty) count else {
      println("Coin: " + coins.head)
      loop(loop1(count, coins.head, coins.tail), coins.tail)
    }
  }

  def loop1(count: Int, coin: Int, coins: List[Int]): Int = {
    println(" -- *loop1 cnt: " + count + ", coin: " + coin + ", coins: "+ coins )
    if(coins.isEmpty) calc(0, count, coin, coins) else {
      loop1(calc(0, count, coin, coins), coin, coins.tail)
    }
  }

  loop(0, coins)

}

fun(11, List(5,2,1))