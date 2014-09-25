def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a>b) acc
    else loop(a+1, f(a) + acc)
  }
  loop(a, 0)
}

sum(x => x * x, 3, 5)

def concat(f: String => String, a: String) = {
  println(f(a))
}

def hello(a: String) = "Hello " + a

concat(hello, "Tomek")


