package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }

  test("pascal: bulk check for row 17") {
    assert(pascal(0, 17) === 1)
    assert(pascal(1, 17) === 17)
    assert(pascal(2, 17) === 136)
    assert(pascal(3, 17) === 680)
    assert(pascal(4, 17) === 2380)
    assert(pascal(5, 17) === 6188)
    assert(pascal(6, 17) === 12376)
    assert(pascal(7, 17) === 19448)
    assert(pascal(8, 17) === 24310)
    assert(pascal(8, 17) === pascal(9, 17))
    assert(pascal(7, 17) === pascal(10, 17))
    assert(pascal(6, 17) === pascal(11, 17))
    assert(pascal(5, 17) === pascal(12, 17))
    assert(pascal(4, 17) === pascal(13, 17))
    assert(pascal(3, 17) === pascal(14, 17))
    assert(pascal(2, 17) === pascal(15, 17))
    assert(pascal(1, 17) === pascal(16, 17))
    assert(pascal(0, 17) === pascal(17, 17))
  }

  test("pascal: check if adding two elements from row 15 returns right value from roe 16") {
    assert(pascal(6,16) === pascal(5,15) + pascal(6, 15))
  }
}
