def fun(money: Int, coins: List[Int]): Int = {
  def count(n: Int, m: List[Int]): Int = {
    if(money==0) 0
    else if(n==0) 1
    else if(n<0 || (m.isEmpty && n>=1)) 0
    else count(n, m.tail) + count(n-m.head, m)
  }
  count(money, coins)
}

fun(11, List(2,3))
