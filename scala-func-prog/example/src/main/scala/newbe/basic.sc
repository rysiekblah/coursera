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
def loop: Boolean = {
  println(".")
  //loop
  true
}
loop
