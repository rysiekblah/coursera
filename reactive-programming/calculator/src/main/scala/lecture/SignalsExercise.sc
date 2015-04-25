import calculator.{Signal, Var}

val num = Var(1)
val twice = Signal(num() * 2)
num() = 2
twice()

var num2 = Var(1)
val twice2 = Signal(num2() * 2)
num2 = Var(2)
twice2()