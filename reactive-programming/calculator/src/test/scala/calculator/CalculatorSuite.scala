package calculator

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import org.scalatest._

import TweetLength.MaxTweetLength

@RunWith(classOf[JUnitRunner])
class CalculatorSuite extends FunSuite with ShouldMatchers {

  /******************
   ** TWEET LENGTH **
   ******************/

  def tweetLength(text: String): Int =
    text.codePointCount(0, text.length)

  test("tweetRemainingCharsCount with a constant signal") {
    val result = TweetLength.tweetRemainingCharsCount(Var("hello world"))
    assert(result() == MaxTweetLength - tweetLength("hello world"))

    val tooLong = "foo" * 200
    val result2 = TweetLength.tweetRemainingCharsCount(Var(tooLong))
    assert(result2() == MaxTweetLength - tweetLength(tooLong))
  }

  test("tweetRemainingCharsCount with a supplementary char") {
    val result = TweetLength.tweetRemainingCharsCount(Var("foo blabla \uD83D\uDCA9 bar"))
    assert(result() == MaxTweetLength - tweetLength("foo blabla \uD83D\uDCA9 bar"))
  }

  test("tweetRemainingCharsCount dynamic changes") {
    val text = Var("1234567890")
    val remining = TweetLength.tweetRemainingCharsCount(text)
    assert(remining() == 130)
    text() = "12345678901234567890"
    assert(remining() == 120)
  }

  test("tweetRemainingCharsCount dynamic changes test") {
    val len = Var(16)
    val color = TweetLength.colorForRemainingCharsCount(len)
    assert(color() == "green")
    len() = 14
    assert(color() == "orange")
    len() = -1
    assert(color() == "red")
  }

  test("colorForRemainingCharsCount with a constant signal") {
    val resultGreen1 = TweetLength.colorForRemainingCharsCount(Var(52))
    assert(resultGreen1() == "green")
    val resultGreen2 = TweetLength.colorForRemainingCharsCount(Var(15))
    assert(resultGreen2() == "green")

    val resultOrange1 = TweetLength.colorForRemainingCharsCount(Var(12))
    assert(resultOrange1() == "orange")
    val resultOrange2 = TweetLength.colorForRemainingCharsCount(Var(0))
    assert(resultOrange2() == "orange")

    val resultRed1 = TweetLength.colorForRemainingCharsCount(Var(-1))
    assert(resultRed1() == "red")
    val resultRed2 = TweetLength.colorForRemainingCharsCount(Var(-5))
    assert(resultRed2() == "red")
  }

  // Polynominal
  test("computeDelta static") {
    assert(0 == Polynomial.computeDelta(Var(4), Var(4), Var(1))())
    assert(-3 == Polynomial.computeDelta(Var(1), Var(1), Var(1))())
    assert(-3 == Polynomial.computeDelta(Var(1), Var(-1), Var(1))())
  }

  test("computeDelta dynamic") {
    val a = Var(1.0)
    val b = Var(1.0)
    val c = Var(1.0)
    assert(-3 == Polynomial.computeDelta(a, b, c)())
    a() = 4.0
    b() = 4.0
    c() = 1.0
    assert(0 == Polynomial.computeDelta(a, b, c)())
    a() = 1.0
    b() = -1.0
    c() = 1.0
    assert(-3 == Polynomial.computeDelta(a, b, c)())
  }

  test("computeSolutions - compute roots -1") {
    val a = Var(2.0)
    val b = Var(-4.0)
    val c = Var(2.0)
    assert(Polynomial.computeSolutions(a, b, c, Polynomial.computeDelta(a, b, c))().size == 1)
    assert(Polynomial.computeSolutions(a, b, c, Polynomial.computeDelta(a, b, c))().contains(1.0))
  }

  test("computeSolutions - compute roots - no roots") {
    val a = Var(-5.0)
    val b = Var(6.0)
    val c = Var(-2.0)
    assert(Polynomial.computeSolutions(a, b, c, Polynomial.computeDelta(a, b, c))().size == 0)
  }

  test("computeSolutions - compute roots -2") {
    val a = Var(-1.0)
    val b = Var(3.0)
    val c = Var(4.0)
    val delta = Polynomial.computeDelta(a, b, c)
    val roots = Polynomial.computeSolutions(a, b, c, delta)
    assert(roots().size == 2)
    assert(roots().contains(-1.0))
    assert(roots().contains(4.0))

    a() = 2.0
    b() = -4.0
    c() = 2.0
    assert(delta() == 0)
    assert(roots().size == 1)
    assert(roots().contains(1.0))

    a() = -1.0
    b() = 3.0
    c() = 4.0
    assert(delta() == 25)
    assert(roots().size == 2)
    assert(roots().contains(-1.0))
    assert(roots().contains(4.0))
  }

  //Calculator - exel sheet test suite
    // calculation
    test("One cell - Literal expr") {
      val literal = Literal(2.0)
      val column:Map[String, Signal[Expr]] = Map("a" -> Signal{literal})
      val res = Calculator.computeValues(column)
      assert(res.size == 1)
      assert(res.apply("a")() == 2.0)
    }

    test("Plus - two literals") {
      val a = Literal(2.0)
      val b = Literal(3.0)
      val plus = Plus(a, b)
      val exprs: Map[String, Signal[Expr]] = Map("a" -> Signal(plus))
      val res = Calculator.computeValues(exprs)
      assert(res.size == 1)
      assert(res.apply("a")() == 5.0)
    }

    test("Plus one Ref and one Literal") {
      val a = Literal(3.0)
      val b = Literal(4.0)
      val ref = Ref("b")
      val expres: Map[String, Signal[Expr]] = Map("a" -> Signal(Plus(a, ref)), "b" -> Signal(b))
      val res = Calculator.computeValues(expres)
      assert(res.size == 2)
      assert(res.apply("a")() == 7.0)
    }

    test("Plus two Ref") {
      val expr:Map[String, Signal[Expr]] = Map(
        "a" -> Signal(Plus(Ref("b"), Ref("c"))),
        "b" -> Signal(Literal(44.0)),
        "c" -> Signal(Literal(11.0))
      )
      assert(Calculator.computeValues(expr).apply("a")() == 55.0)
    }

    test("3 Plus") {
      val expr:Map[String, Signal[Expr]] = Map(
        "a" -> Signal(Plus(Plus(Ref("b"), Ref("c")), Plus(Ref("d"), Ref("e")))),
        "b" -> Signal(Literal(44.0)),
        "c" -> Signal(Literal(11.0)),
        "d" -> Signal(Literal(11.0)),
        "e" -> Signal(Literal(11.0))
      )
      assert(Calculator.computeValues(expr).apply("a")() == 77.0)
    }

  test("Divide by zero 1") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Divide(Literal(6.0), Literal(0.0)))
    )
    assert(Calculator.computeValues(expr).apply("a")() == Double.PositiveInfinity)
  }

  test("Divide by zero 2") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Divide(Literal(-6.0), Literal(0.0)))
    )
    assert(Calculator.computeValues(expr).apply("a")() == Double.NegativeInfinity)
  }

    test("Not exist Ref") {
      val expr:Map[String, Signal[Expr]] = Map(
        "a" -> Signal(Plus(Ref("b"), Literal(3.0)))
      )
      assert(java.lang.Double.isNaN(Calculator.computeValues(expr).apply("a")()))
    }

    test("No Cyclic") {
      val expr:Map[String, Signal[Expr]] = Map(
        "a" -> Signal(Ref("b")),
        "b" -> Signal(Ref("c")),
        "c" -> Signal(Literal(11.0))
      )
      assert(Calculator.computeValues(expr).apply("a")() == 11.0)
      assert(Calculator.computeValues(expr).apply("b")() == 11.0)
      assert(Calculator.computeValues(expr).apply("c")() == 11.0)
    }

  test("Cyclic 1") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Ref("b")),
      "b" -> Signal(Ref("a")),
      "c" -> Signal(Literal(11.0))
    )
    assert(java.lang.Double.isNaN(Calculator.computeValues(expr).apply("a")()))
  }

  test("Cyclic 2") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Ref("b")),
      "b" -> Signal(Ref("c")),
      "c" -> Signal(Ref("a"))
    )
    assert(java.lang.Double.isNaN(Calculator.computeValues(expr).apply("a")()))
  }

  test("Cyclic 3") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Ref("b")),
      "b" -> Signal(Plus(Ref("a"), Ref("a")))
    )
    assert(java.lang.Double.isNaN(Calculator.computeValues(expr).apply("a")()))
  }

  test("Cyclic - a=Ref(b), b=Ref(a) + Ref(c)") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Ref("b")),
      "b" -> Signal(Plus(Ref("a"), Ref("c"))),
      "c" -> Signal(Literal(4.0))
    )
    assert(java.lang.Double.isNaN(Calculator.computeValues(expr).apply("a")()))
  }

  test("Cyclic - a=Ref(b), b=Ref(a) + Literal") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Ref("b")),
      "b" -> Signal(Plus(Ref("a"), Literal(4.0)))
    )
    assert(java.lang.Double.isNaN(Calculator.computeValues(expr).apply("a")()))
  }

  test("Cyclic to itself") {
    val expr:Map[String, Signal[Expr]] = Map(
      "a" -> Signal(Ref("a"))
    )
    assert(java.lang.Double.isNaN(Calculator.computeValues(expr).apply("a")()))
  }
}
