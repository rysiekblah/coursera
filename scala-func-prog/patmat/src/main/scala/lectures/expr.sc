import lectures.{Expr, UnOp, BinOp, Var, Number}
import math.{E, Pi}

val v = Var("x")
val op = BinOp("+", Number(1), v)
val op2 = op.copy(left = Number(1))
op == op2

def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e
  case BinOp("+", e, Number(0))=> e
  case BinOp("*", e, Number(1)) => e
  case Var(_) => println("Var is here"); expr
  case _ => expr
}

simplifyTop(UnOp("-", UnOp("-", Var("d"))))
simplifyTop(Var("yo"))

val pi = Pi
E match {
  case Pi => "hm: " + Pi
  case _ => "OK"
}

E match {
  case pi => "hm: " + pi
  case _ => "OK"
}

E match {
  case `pi` => "hm: " + `pi`
  case _ => "OK"
}

