def scalarProduct1(xs: Vector[Double], ys: Vector[Double]) =
  (xs zip ys).map(xy => xy._1*xy._2).sum

def scalarProduct(xs: Vector[Double], ys: Vector[Double]) = {
  (for {
    (x,y) <- xs zip ys
  } yield x*y).sum
}

val x = Vector(1.3, 1.4, 1.5)
val y = Vector(0.1, 0.2, 0.3)

scalarProduct(x,y)
scalarProduct1(x,y)

val l = List(1,2,3,4,5)

for {
  i <- 0 until 10
  if(i<6)
} yield i