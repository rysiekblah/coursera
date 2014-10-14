package lectures

import utils.{Nil, Cons, List}

/**
 * Created by tomek on 10/14/14.
 */
object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1, new Cons(x2, new Nil))
  def apply[T](x: T): List[T] = new Cons[T](x, new Nil)
  def apply[T](): List[T] = new Nil[T]
}
