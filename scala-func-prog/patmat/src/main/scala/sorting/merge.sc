def merge(xs:List[Int], ys:List[Int]):List[Int] = xs match {
  case Nil => ys
  case x :: xs1 => ys match {
    case Nil => xs
    case y :: ys1 => if (x < y) x :: merge(xs1, ys)
    else y :: merge(xs,  ys1)
  }
}

def merge2(xxs:List[Int], yys:List[Int]):List[Int]= (xxs,yys) match {
  case (Nil, yys) => yys
  case (xxs, Nil) => xxs
  case (x :: xs1, y :: ys1) => if (x < y) x :: merge2(xs1, yys)
  else y :: merge2(xxs, ys1)
}

def msort(xs:List[Int]):List[Int] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    val (fst, snd) = xs splitAt n
    merge2(msort(fst), msort(snd))
  }
}

val l = List(2,7,8,4,2,1,3,7,3,2,9,0)
msort(l)

