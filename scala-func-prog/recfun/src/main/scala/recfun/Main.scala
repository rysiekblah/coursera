package recfun
import common._
import scala.util.control.Breaks._

object Main {
  def main(args: Array[String]) {
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(pascal(col, row) + " ")
//      println()
//    }
//    println(pascal(4, 2))

    println(balance("(tomek)(--".toList))

  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0 || c == 0 || c == r) {
      1
    } else {
      pascal(c - 1, r - 1) + pascal(c, r -1 )
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def check(ch: Char): Int = ch match {
      case '(' => 1
      case ')' => -1
      case _ => 0
    }

    def blnc(chs: List[Char], cnt: Int): Boolean = {
      if (chs.isEmpty) cnt == 0
      else if(cnt<0) false
      else {
        blnc(chs.tail, cnt + check(chs.head))
      }
    }

    blnc(chars, 0)
  }

  def balanceIterative(chars: List[Char]): Boolean = {

    var cnt: Int = 0;

    def check(ch: Char): Int = ch match {
      case '(' => 1
      case ')' => -1
      case _ => 0
    }

    breakable {
      for (item <- chars) {
        cnt += check(item)
        if(cnt<0) break
      }
    }

    !(cnt<0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
