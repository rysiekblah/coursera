def squereList(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => y*y :: squereList(ys)
}

def squereListMap(xs: List[Int]): List[Int] = xs map (x => x*x)

val l = List(1,2,3,4,5)

squereList(l)
squereListMap(l)
