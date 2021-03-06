
val t0 = new Empty
val t1 = new NonEmpty(2, new Empty, new Empty)
val t2 = t1 incl 4 incl 5 incl 1 incl 20 incl 15
val t3 = t1 incl 3 incl 100
val t4 = t2.union(t3)
t4.foreach(x => x+1)
val t5 = t4.filter(x => x == 100 || x == 5)

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
    if(p(elem)) left.filterAcc(p, right.filterAcc(p, acc incl elem))
    else left.filterAcc(p, right.filterAcc(p, acc))
  }
}

