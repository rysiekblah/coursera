package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: example given in instructions") {
    assert(countChange(4,List(1,2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }

  test("countChange: zero money") {
    assert(countChange(0, List(1, 2, 3, 4)) === 0)
  }

  test("countChange: no money for change") {
    assert(countChange(100, List()) === 0)
  }

  test("countChange: check 5 and 1,2,3") {
    assert(countChange(5, List(1, 2, 3)) === 5)
  }

  test("countChange: check 5 and 2,1,3") {
    assert(countChange(5, List(2, 1, 3)) === 5)
  }

  test("countChange: check 5 and 1,3,2") {
    assert(countChange(5, List(1, 3, 2)) === 5)
  }

  test("countChange: check 5 and 3,2,1") {
    assert(countChange(5, List(3, 2, 1)) === 5)
  }

  test("countChange: check 5 and 3,1,2") {
    assert(countChange(5, List(3, 2, 1)) === 5)
  }
}
