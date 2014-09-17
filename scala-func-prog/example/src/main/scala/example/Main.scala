package example

/**
 * Created by tomek on 9/16/14.
 */
object Main extends App {
  try {
    println(Lists.max(List()))
  } catch {
    case e: NoSuchElementException => println("Yes, right exception has been thrown");
  }

  println(sum(List()))

  val list: List[Int] = List(3, 4, 3, 6, 7)
  println("Head: " + list.head)
  println("Index of head: " + list.indexOf(list.head))

  def sum(xs: List[Int]): Int = {
    if(xs.isEmpty) {
      println("Empty list")
      0
    } else {
      3
    }
  }

  // Make a list via the companion object factory
  val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

  // Make a list element-by-element
  val when = "AM" :: "PM" :: List()

  println("Days: " + days)
  println("When: " + when)


}
