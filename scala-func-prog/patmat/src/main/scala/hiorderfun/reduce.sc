def sum(xs: List[Int]) = (0 :: xs) reduceLeft((x,y) => x + y)
def sum2(xs: List[Int]) = (0 :: xs) reduceLeft(_ + _)
def sum3(xs: List[Int]) = (0 :: xs) reduceRight(_ + _)

sum(List(1,2,3,4,5))
sum2(List(1,2,3,4,5))
sum3(List(1,2,3,4,5))

def diff1(xs: List[Int]) = (0 :: xs) reduce(_ - _)
def diff2(xs: List[Int]) = (0 :: xs) reduceLeft(_ - _)
def diff3(xs: List[Int]) = (0 :: xs) reduceRight(_ - _)

val l = List(1, -2)
diff1(l)
diff2(l)
diff3(l)
