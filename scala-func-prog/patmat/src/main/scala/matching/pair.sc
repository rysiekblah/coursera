val fruits = List("apple", "plum", "tomato")
val List(a,b,c) = fruits
def isort1(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else insert1(xs.head, isort1(xs.tail))

def insert1(x: Int, xs: List[Int]): List[Int] =
  if(xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert1(x, xs.tail)

isort1(List(4,9,2,4,1,0,4))

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => insert(x, isort(xs1))
}
def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}


isort(List(4,9,2,4,1,0,4))