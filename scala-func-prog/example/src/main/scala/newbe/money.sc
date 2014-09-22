//def countChange(money: Int, coins: List[Int]): Int= {
//
//  def calc(sum: Int, coin: Int): Int = {
//    if(sum>money) sum-coin else calc(sum + coin, coin)
//  }
//
//  def loop(count: Int, sum: Int, coin: Int): Int = {
//    print("sum: " + sum + ", ")
//    if(sum == money) count
//    else loop(count+1, calc(sum, coin), coin)
//  }
//
//
//  loop(0, 0, 3)
//
//}

def fun(money: Int, coins: List[Int]): Int = {

  def sumi(sum: Int, coin: Int): Int = {
    //println(" ----- sumi coin: " + coin + ", sum: " + sum)
    if(sum>=money) sum-coin else sumi(sum + coin, coin)
  }

  def calc(sumaa: Int, count: Int, coin: Int, rest: List[Int]): Int = {
    println(" --- *calc coin: " + coin + ", coins: " + rest)
    if(rest.isEmpty) {
      val suma = sumi(sumaa, coin)
      //println(" --- " + rest.head+ ", suma: " + suma + ", coin: " + coin)
      if(suma+coin == money) {
        //println("  ------+ money yes: " + (suma+coin))
        count+1
      } else
        count
    }
    else {
      val suma = sumi(sumaa, coin)
      println(" --- *calc suma: " + suma + ", coin: " + coin)
      if(suma+coin == money) {
        println("  ------+ money yes: " + (suma+coin))
        count+1
      } else
        calc(suma, count, rest.head, rest.tail)
    }
  }

  

  def loop(count: Int, coins: List[Int]): Int = {
    if(coins.isEmpty) count else {
      println("Coin: " + coins.head)
      val cnt = loop1(count, coins.head, coins.tail)
        //calc(0, count, coins.head, coins.tail)
      println(" ------ COUNT: " + cnt)
      loop(cnt, coins.tail)
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