
def msort[T](xs: List[T])(lt: (T, T) => Boolean):List[T]  = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs:List[T], ys:List[T]):List[T] = (xs,ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => if (lt(x,y)) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msort(fst)(lt), msort(snd)(lt))
  }
}

def msortOrg[T](xs: List[T])(ord: Ordering[T]):List[T]  = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs:List[T], ys:List[T]):List[T] = (xs,ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => if (ord.lt(x,y)) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msortOrg(fst)(ord), msortOrg(snd)(ord))
  }
}

def msortOrgImplicit[T](xs: List[T])(implicit ord: Ordering[T]):List[T]  = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs:List[T], ys:List[T]):List[T] = (xs,ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => if (ord.lt(x,y)) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msortOrgImplicit(fst), msortOrgImplicit(snd))
  }
}

msort(List(4,8,2,3,0,1,100))((x: Int, y: Int) => x < y)
msort(List("tomek", "rysiek","ania","justyna"))((x: String, y:String) => x.compareTo(y)<0)

msort(List(4,8,2,3,0,1,100))((x, y: Int) => x < y)
msort(List("tomek", "rysiek","ania","justyna"))((x, y) => x.compareTo(y)<0)

msortOrg(List(4,8,2,3,0,1,100))(Ordering.Int)
msortOrg(List("tomek", "rysiek","ania","justyna"))(Ordering.String)

msortOrgImplicit(List(4,8,2,3,0,1,100))(Ordering.Int)
msortOrgImplicit(List("tomek", "rysiek","ania","justyna"))(Ordering.String)