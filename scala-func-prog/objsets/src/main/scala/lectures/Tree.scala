package lectures

/**
 * Created by tomek on 10/6/14.
 */
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
  def foreach(f: Int => Int)
  def filter(p: Int => Boolean): IntSet = filterAcc(p, new Empty)
  def filterAcc(p: Int => Boolean, acc: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
  def foreach(f: Int => Int) = ()
  override def filterAcc(p: (Int) => Boolean, acc: IntSet): IntSet = acc
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  override def toString = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet = {
    ((left union right) union other) incl elem
  }
  def foreach(f: Int => Int) = {
    print(" " + f(elem) + " ")
    left.foreach(f)
    right.foreach(f)
  }

  override def filterAcc(p: (Int) => Boolean, acc: IntSet): IntSet = {
    if(p(elem)) acc incl elem
    left.filterAcc(p, acc)
    right.filterAcc(p, acc)
  }
}