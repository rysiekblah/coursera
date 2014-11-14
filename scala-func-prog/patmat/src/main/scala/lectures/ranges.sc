val i = Vector(1 to 5)
val s = Vector("tomek", "kozlowski")
val mapper = i zip s
mapper.unzip

def takePair(pair: (Vector[Int], Vector[String])) = pair._1

(1 to 5) flatMap (x => ('a' to 'c') map (y=>(x,y)))

val x = Vector(1.3, 1.4, 1.5)
val y = Vector(0.1, 0.2, 0.3)

val zipxy = x zip y
val mapz = zipxy.map(xy => xy._1 * xy._2)
val sumz = mapz.sum

def scalarProduct(xs: Vector[Double], ys: Vector[Double]) =
  (xs zip ys).map(xy => xy._1*xy._2).sum

def scalarPattern(xs: Vector[Double], ys:Vector[Double]) =
  (xs zip ys).map{
    case (x,y) => x*y
  }.sum

scalarProduct(x,y)

def isPrime(n: Int): Boolean = {
  (2 to n-1).forall(x => n%x!=0)
}

(1 to -10)

isPrime(4)
isPrime(5)
isPrime(6)