val fruits1 = Map("apple" -> 6, "orange" -> 2, "plum" -> 12)
val fruits2 = Map("apple" -> 1, "orange" -> 4, "plum" -> 9, "melon" -> 2)
class Fruit(val fruits: Map[String, Int]) {
  def + (other: Fruit) = new Fruit(fruits ++ (other.fruits map adjust))
  def adjust(fruit: (String, Int)): (String, Int) = {
    val (name, amount) = fruit
    fruits.get(name) match {
      case Some(amt) => name -> (amount + amt)
      case None => name -> amount
    }
  }
}

class Poly(terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
  def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coeff) = term
    terms + (exp -> (coeff+ terms(exp)))
  }

  override def toString =
    (for ((exp, coeff) <- terms.toList.sorted.reverse)
    yield coeff+"x^"+exp) mkString " + "
}

val f1 = new Fruit(fruits1)
val f2 = new Fruit(fruits2)

f1+f2

// fold
val l = List(1,3,5,7,9)
l.foldLeft(0)(_+_)
l.foldRight(0)(_+_)

fruits1.foldLeft(0)((acc, entry)=>acc+entry._2)