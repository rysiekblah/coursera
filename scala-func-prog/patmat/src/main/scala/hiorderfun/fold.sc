def sum(xs: List[Int]) = (xs foldLeft(0)) (_ + _)

def concat[T](xs: List[T], ys: List[T]): List[T] =
  (xs foldRight ys) (_ :: _)

def fun(xs: List[Int], factor: Int) = xs map(_ * factor)
fun(List(1,2,3,4,5), 2)

def mapFun[T,U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())(???)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)(???)