def from(n: Int): Stream[Int] = n #:: from(n+1)

val nats = from(0)

nats.map(_*4).take(5).toList
nats.filter(_%4 == 0).take(5).toList

def sieve(s: Stream[Int]): Stream[Int] =
  s.head #:: sieve(s.tail.filter(_%s.head!=0))

sieve(from(2)).take(10).toList

def sqrtStream(x: Double): Stream[Double] = {
  def improve(guess: Double) = (guess + x/guess)/2
  lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
  guesses
}

def isGoodEnough(guess: Double, x: Double) =
  math.abs((guess*guess - x)/x)<0.0001

sqrtStream(4).take(4).toList
sqrtStream(4).filter(isGoodEnough(_,4)).take(5).toList

val xs = from(1) map (_ * 10)
val ys = from(1) filter (_ % 10 == 0)