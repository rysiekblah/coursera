def last[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("last of empty list")
  case List(x) => xs
  case y :: ys => last(ys)
}

def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case z :: zs => z :: concat(zs, ys)
}

def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ++ List(y)
}

def removeAt[T](n: Int, xs: List[T]) = {
  if(n>xs.length) xs
  else xs.take(n) ++ xs.drop(n+1)
}

def flatten(xs: List[Any]): List[Any] = {
  def macheroAcc(l: List[Any]): List[Any] = l match {
    case List() => Nil
    case x :: xs => (x match {
      case list: List[Any] => macheroAcc(list)
      case item => List(item)
    }) ::: macheroAcc(xs)
  }
  macheroAcc(xs)
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))
flatten(List(List(List(1))))
//>   res0: List[Any] = List(1, 1, 2, 3, 5, 8)

//val l1 = List(1,2,3,4,5,6,7)
//val l2 = List(99, 88, 77)
//last(l1)
//init(l1)
//concat(l1, l2)
//reverse(l1)
//removeAt(2, l1)
