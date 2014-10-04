def nth(n: Int, a: List[Int]): Int = {
  if(a.isEmpty) throw new IndexOutOfBoundsException
  else if(n==0) a.head else nth(n-1, a.tail)
}

val list: List[Int] =
  new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, new Cons(6, new Cons(7, new Nil)))))))

val v = nth(9, list)
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}
class Nil[T] extends List[T] {
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}