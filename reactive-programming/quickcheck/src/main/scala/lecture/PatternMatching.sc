val f: String => String = { case "ping" => "pong" }
f("ping")

val f2: PartialFunction[String, String] = {
  case "ping" => "ping"}

f2.isDefinedAt("ping")
f2.isDefinedAt("pong")

val f3: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case x :: y :: rest => "two"
}

f3(List(1, 2, 3))
f3.isDefinedAt(List(1, 2, 3))

val f4: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case x :: rest =>
    rest  match {
      case Nil => "two"
    }
}

f4(List(1))
f4.isDefinedAt(List(1, 2, 3))