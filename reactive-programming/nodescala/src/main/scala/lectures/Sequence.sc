import scala.concurrent.{Promise, Future}
import concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

//def sequence[T](fts: List[Future[T]]): Future[List[T]] = fts match {
//  case Nil => Future(Nil)
//  case ft::fts => ft.flatMap(t=>sequence(fts).flatMap(ts=>Future(t::ts)))
//}

//val list = List(Future{1}, Future{2}, Future{3})
//val res = sequence(list)
//res.onComplete {
//  case Success() => println("res")
//  case Failure(ex) => println("ERR")
//}

val f1 = Future{
  println("F1 started")
  Thread.sleep(1000)
  println("... end")
  s"tomek"
}

//f1.onSuccess{case r => println("res $r")}

def fun(): Future[String] = {
  val p = Promise[String]()
  Future {
    println("Start processing...")
    Thread.sleep(1000)
    p.success("OK")
    println("processing done!")
  }
  p.future
}

val f2 = fun()
f2.onComplete {
  case Success(text) => println("processed string: $text")
  case Failure(ex) => println("$ex")
}

//f1.onComplete {
//  case Success(r) => println("res $r")
//  case Failure(ex) => println("ERR")
//}
