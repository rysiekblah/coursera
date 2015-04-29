package lecture.user

import lecture.User

/**
 * Created by tomek on 4/26/15.
 */
class Order[T](u: => User[T]) {
  //var myExpr: () => T = _
  //var myVal: T = _
  var user: User[T] = u

  def update(u: => User[T]) = user = u

  def apply() = {
    //println("Somethinglkslkjlskf")
    user
  }
}

object Order {
  def apply[T](user: => User[T]) =  {
    //println("Order with user: " + user.show)
    new Order(user)
  }
}
