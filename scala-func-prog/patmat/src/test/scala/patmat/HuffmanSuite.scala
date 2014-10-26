package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    val t3 = Leaf('e', 1)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("weight of t2") {
    new TestTrees {
      assert(weight(t2) === 9)
    }
  }

  test("weight of t3 - one leaf only") {
    new TestTrees {
      assert(weight(t3) === 1)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("chars of t1") {
    new TestTrees {
      assert(chars(t1) === List('a','b'))
    }
  }

  test("chars of one leaf") {
    new TestTrees {
      assert(chars(t3) === List('e'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list -1-") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("combine of some leaf list -2-") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4), Leaf('v', 6), Leaf('n', 8), Leaf('g', 9))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), Leaf('v',6), Leaf('n',8), Leaf('g',9)))
  }

  test("test until -1-") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4), Leaf('v', 6), Leaf('n', 8), Leaf('g', 9))
    println(until(singleton, combine)(leaflist))
  }

  test("test create code tree") {
    //BACADAEAFABBAAAGAH
    val chars = List('B','A','C','A','D','A','E','A','F','A','B','B','A','A','A','G','A','H')
    println(createCodeTree(chars))
  }

  test("test") {
    val chars = List('B','A','C','A','D','A','E','A','F','A','B','B','A','A','A','G','A','H')
    val tree = Fork(Fork(Fork(Fork(Fork(Fork(Fork(Leaf('H',1),Leaf('G',1),List('H', 'G'),2),Leaf('F',1),List('H', 'G', 'F'),3),Leaf('E',1),
      List('H', 'G', 'F', 'E'),4),Leaf('D',1),List('H', 'G', 'F', 'E', 'D'),5),Leaf('C',1),List('H', 'G', 'F', 'E', 'D', 'C'),6),
      Leaf('B',3),List('H', 'G', 'F', 'E', 'D', 'C', 'B'),9),Leaf('A',9),List('H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'),18)

    assert(decode(tree, encode(tree)(chars)) === chars)
    println(chars)
    println(decode(tree, encode(tree)(chars)))
  }

  test("test quick encde") {
    val chars = List('B','A','C','A','D','A','E','A','F','A','B','B','A','A','A','G','A','H')
    val tree = Fork(Fork(Fork(Fork(Fork(Fork(Fork(Leaf('H',1),Leaf('G',1),List('H', 'G'),2),Leaf('F',1),List('H', 'G', 'F'),3),Leaf('E',1),
      List('H', 'G', 'F', 'E'),4),Leaf('D',1),List('H', 'G', 'F', 'E', 'D'),5),Leaf('C',1),List('H', 'G', 'F', 'E', 'D', 'C'),6),
      Leaf('B',3),List('H', 'G', 'F', 'E', 'D', 'C', 'B'),9),Leaf('A',9),List('H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'),18)

    assert(decode(tree, quickEncode(tree)(chars)) === chars)
    println(chars)
    println(decode(tree, quickEncode(tree)(chars)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
      //println(decodedSecret)
    }
  }
}
