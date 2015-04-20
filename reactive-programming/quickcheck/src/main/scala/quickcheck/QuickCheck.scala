package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { h:H =>
    val m = if(isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h))==m
  }

  lazy val genHeap: Gen[H] = for {
    v <- arbitrary[Int]
    h <- oneOf(const(empty), genHeap)
  } yield insert(v, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("put and remove") = forAll{in: Int =>  isEmpty(deleteMin(insert(in, empty)))}

  property("insert 2 values, not equal") = forAll {(in1: Int, in2:Int) =>
    val set1 = insert(in1, insert(in2, empty))
    val set2 = insert(in2, insert(in1, empty))
    if(in1>in2) findMin(set1) == in2 && findMin(set2) == in2
    else  findMin(set1) == in1 && findMin(set2) == in1
  }

  property("sorted seq") = forAll { (h: H) =>
    def insertElem(h: H, last: Int): Boolean = {
      val min = findMin(h)
      val h2 = deleteMin(h)
      last <= min && (isEmpty(h2) || insertElem(h2, min))
    }
    isEmpty(h) || insertElem(h, Int.MinValue)
  }

  property("meld min") = forAll { (h1: H, h2: H) =>
    val h = meld(h1, h2)
    val min = findMin(h)
    min == findMin(h1) || min == findMin(h2)
  }

  property("insert list then check") = forAll { l: List[Int] =>
    def insertElem(h: H, l: List[Int]): Boolean = {
      if (isEmpty(h)) {
        l.isEmpty
      } else {
        !l.isEmpty && findMin(h) == l.head && insertElem(deleteMin(h), l.tail)
      }
    }
    val sl = l.sorted
    val h = l.foldLeft(empty)((he, a) => insert(a, he))
    insertElem(h, sl)
  }

}
