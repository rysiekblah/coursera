import calculator.{NoSignal, Var, Signal}
import lecture.User
import lecture.user.Order
val n1 = new User("tomek")
n1.show
val n2 = User("Simaple man")
n2.show
val o1 = Order(n1)
o1()
var a = Var(2)
var b = Signal(a())
b()
a() = 33
b()
