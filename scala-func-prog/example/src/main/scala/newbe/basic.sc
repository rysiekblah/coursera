println("Hello world")
val msg = "tomekJestSuper"
val capitalChar = msg.exists(_.isUpper)
def max1(x: Int, y: Int): Int = {
  if (x > y) {
    x
  } else {
    y
  }
}
def max2(x: Int, y: Int) = if (x > y) x else y
max1(4, 5)
max2(4, 5)
def greet() = println("Hello there!")
greet()
def and(x: Boolean, y: Boolean) = if(x) y else false
and(true, false)
and(true, true)
and(false, true)
def or(x: Boolean, y: Boolean) = if(!x) y else true
or(true, true)
or(false, false)
or(true, false)
or(false, true)
//def loop: Boolean = {
//  println(".")
//  //loop
//  true
//}
//loop
def factorial(a: Int): Int = {
  if(a==1) 1 else a*factorial(a-1)
}
def factorial2(a: Int): Int = {
  def fact(res: Int, a: Int): Int = {
    if(a==0) res else fact(res*a, a-1)
  }
  fact(1, a)
}

factorial(6)
factorial2(6)


val list = List(2, 5, 3, 1)
val list2 = list.sortWith(_>_)

