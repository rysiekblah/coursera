
def add(a: Array[Int]): Int = {
  def calc(carry: Int, ix: Int): Int = {
    if(ix>=0 && carry == 1) increment(ix)
    else carry
  }

  def increment(index: Int): Int = {
    if(a(index) == 9) {
      a(index) = 0
      calc(1, index-1)
    } else {
      a(index) += 1
      0
    }
  }

  increment(a.length-1)

}

val a = Array(9, 8, 9)
add(a)

a(0)
a(1)
a(2)

