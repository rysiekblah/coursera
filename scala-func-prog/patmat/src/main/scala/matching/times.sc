
val litery = List('s', 'a', 'w', 'a', 'a', 'w', 'a')


def times(chars: List[Char]): List[(Char, Int)] = {
  def timesAcc(chars: List[Char], acc: List[(Char, Int)]): List[(Char, Int)] = chars match {
    case List() => acc
    case x :: xs => iterateAcc((x, 1), timesAcc(xs, acc))
  }

  def iterateAcc(pair: (Char, Int), ps: List[(Char, Int)]): List[(Char, Int)] = ps match {
    case List() => List(pair)
    case x :: xs =>
      if (x._1 == pair._1) (pair._1, x._2 + 1) :: xs
      else x :: iterateAcc(pair, xs)
  }
  timesAcc(chars, Nil)
}



def acc(ch: Char, pair: (Char, Int)): (Char,Int) = pair match {
  case (`ch`, _) => (ch, pair._2 + 1)
  case _ => pair
}

times(litery)

//iterateAcc(('a', 1), List(('s', 2), ('a', 3)))
