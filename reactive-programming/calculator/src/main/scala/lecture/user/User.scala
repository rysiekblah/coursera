package lecture

/**
 * Created by tomek on 4/26/15.
 */
class User(name: String) {
  def this() = this("unassigned")
  val n: String = name
  def show = println("Name: "+ n)
}

object User {
  def apply(name: String) = new User(name)
}