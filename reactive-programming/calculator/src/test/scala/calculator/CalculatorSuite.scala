package calculator

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import org.scalatest._

import TweetLength.MaxTweetLength

@RunWith(classOf[JUnitRunner])
class CalculatorSuite extends FunSuite with ShouldMatchers {

//  def signal1(sig: Signal[Int]): Signal[Int] = {
//    val vSig = sig()
//    Signal(vSig)
//  }
//
//  def signal2(sig: Signal[Int]): Signal[Int] = {
//    val vSig = sig()
//    Signal({
//      val vSig = sig()
//      vSig
//    }
//    )
//  }
//
//  // Signal tests
//  test("Signal triger check") {
//    var sig1 = Signal(123)
//    val sig2 = signal1(sig1)
//    assert(sig1() == sig2())
//    sig1 = Signal(2)
//    assert(sig1() != sig2())
//  }
//
//  test("Signal triger check 2") {
//    var sig1 = Signal(123)
//    val sig2 = signal2(sig1)
//    assert(sig1() == sig2())
//
//    assert(sig1() == sig2())
//  }

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

}
