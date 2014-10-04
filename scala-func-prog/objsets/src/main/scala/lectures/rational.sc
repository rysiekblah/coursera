class Rational(x: Int, y: Int) {

  require(y != 0, "denominator can't be zero")

  def numer = x
  def denom = y

  private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b, a%b)
  private val g = gcd(x, y)
  private val gg = gcd(numer, denom)

  def add(r: Rational) =
    new Rational(numer*r.denom + denom*r.numer, denom*r.denom)

  def sub(r: Rational) =
    new Rational(numer*r.denom - denom*r.numer, denom*r.denom)

  def mul(r: Rational) =
    new Rational(numer*r.numer, denom*r.denom)

  def neg = new Rational(-numer, denom)

  def less(that: Rational) = numer*that.denom < that.numer*denom

  def max(that: Rational) = if(this.less(that)) that else this

  override def toString = numer / g + "/" + denom / g
}

def addRational(a: Rational, b: Rational) = {
  new Rational(a.numer*b.denom + a.denom*b.numer, a.denom*b.denom)
}
addRational(new Rational(1, 2), new Rational(2, 3))

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.sub(y).sub(z)
z.less(x)
z.max(x)
x.max(z)