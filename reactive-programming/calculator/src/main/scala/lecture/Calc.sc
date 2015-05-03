import calculator._

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

val v = Var("x")
val op = BinOp("+", Number(2.0), v)
v.name
op.operator

def fun(expr: Signal[Expr]) = expr() match {
  case BinOp(_,_,_) => println("binop")
  case _ => println("ohers")
}

def bar(expr: Map[String, Signal[Expr]]) = {

}
fun(Signal(op))
fun(Signal(v))
val exprs: Map[String, Signal[Expr]] = Map("one" -> Signal(op), "two" -> Signal{v})
bar(exprs)

exprs.apply("one")()
exprs.isDefinedAt("tw")
val n = 2.3 + Double.NaN



//def getReferenceExpr(name: String, references: Map[String, Signal[Expr]]) = {
//  references.get(name).fold[Expr] {
//    Literal(Double.NaN)
//  } { exprSignal =>
//    exprSignal()
//  }
//}