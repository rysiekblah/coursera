package lecture

/**
 * Created by tomek on 4/26/15.
 */
class User[T](name: T) {
//  def this() = this("unassigned")
//  var n: T = name
//  //var myExpr: () => String = _
//  def show = println("Name: "+ n)
//
//  def apply() = n
//
//  def update(s: String) = {
//    //myExpr = () => s
//    n = s
//  }

}

object User {
  def apply[T](name: T) = new User(name)
}