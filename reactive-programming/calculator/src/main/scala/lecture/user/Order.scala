package lecture.user

import lecture.User

/**
 * Created by tomek on 4/26/15.
 */
class Order[T](user: => T) {
  var myExpr: () => T = _
  var myVal: T = _

  def update(user: => T) = myVal = user

  def apply() = {
    myVal
  }
}

object Order {
  def apply[T](user: => T) = new Order(user)
}
