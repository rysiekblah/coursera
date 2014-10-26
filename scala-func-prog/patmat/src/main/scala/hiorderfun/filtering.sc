def posElem(xs:List[Int]):List[Int]= xs match {
  case Nil => xs
  case y :: ys => if(y>0) y :: posElem(ys) else posElem(ys)
}

def posElemFilter(xs:List[Int]):List[Int] = xs filter(x=>x>0)
def posElemPredicate[T](xs:List[T])(f: T => Boolean):List[T] = xs filter(f)
def filetrFilerNot[T](xs:List[T])(f: T => Boolean):List[T] = xs filterNot f
def filetrFilerPart[T](xs:List[T])(f: T => Boolean) = xs partition f
def filterTakeWhile[T](xs:List[T])(f:T=>Boolean) = xs takeWhile f
def filterDropWhile[T](xs:List[T])(f:T=>Boolean) = xs dropWhile f

def pack[T](xs:List[T]):List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (head,tail) = xs partition (y=>x==y)
    head :: pack(tail)
}

def encode[T](xs:List[T]):List[(T,Int)] = {
  def encodeAcc(xx:List[List[T]]):List[(T,Int)] = xx match {
    case Nil => Nil
    case y :: ys => (y.head, y.length) :: encodeAcc(ys)
  }
  encodeAcc(pack(xs))
}

def encode2[T](xs:List[T]):List[(T,Int)] = pack(xs) map (ys => (ys.head, ys.length))

posElem(List(-3, -5, 3,2,1,5,-4))
posElemPredicate(List(-3, -5, 3,2,1,5,-4))((x:Int) => x>0)

val l = List(1,4,7,3,-1,0)
l.partition((x:Int)=>x>0)
filetrFilerPart(l)(x => x>0)
val lsLT = l.sortWith(_<_)
val lsGT = l.sortWith(_>_)
filterTakeWhile(lsLT)(x => x<4)
filterDropWhile(l.sortWith(_>_))(x => x>4)

pack(List("a", "a", "a", "b", "c", "c", "a"))
encode2(List("a", "a", "a", "b", "c", "c", "a"))