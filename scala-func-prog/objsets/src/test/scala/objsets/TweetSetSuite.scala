package objsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)
    val set6 = set1.incl(new Tweet("wbg", "wewerwe", 1))
      .incl(new Tweet("1", "a", 7))
      .incl(new Tweet("qwe", "df", 4))
      .incl(new Tweet("34", "f", 6))
    val set7 = set1
      .incl(new Tweet("s", "wewerwe", 101))
      .incl(new Tweet("tom", "a", 72))
      .incl(new Tweet("zyg", "sd", 72))
      .incl(new Tweet("qwe", "df", 344))
      .incl(new Tweet("34", "f", 6))
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  test("test") {
    assert(1 != 2)
  }

  test("filter: on empty set") {
    new TestSets {
      assert(size(set1.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }

  test("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set1)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(set1.union(set5)) === 4)
    }
  }

  test("mostRecent: check") {
    new TestSets {
      assert(set6.mostRetweeted.retweets === 7)
      assert(set7.mostRetweeted.retweets === 344)
    }
  }

  test("mostRecent: check if removing has occured") {
    new TestSets {
      assert(set7.mostRetweeted.retweets === 6)
      var s = set7.remove(set7.mostRetweeted)
      assert(s.mostRetweeted.retweets === 72)
      s = s.remove(s.mostRetweeted)
      assert(s.mostRetweeted.retweets === 72)
      s = s.remove(s.mostRetweeted)
      assert(s.mostRetweeted.retweets === 101)
      s = s.remove(s.mostRetweeted)
      assert(s.mostRetweeted.retweets === 344)
    }
  }

  test("remove: check it") {
    new TestSets {
      assert(set5.contains(d) === true)
      val s = set5.remove(d)
      assert(s.contains(d) === false)
    }
  }

  test("descending: set5") {
    new TestSets {
      val trends = set5.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
    }
  }

  /*val set7 = set1
      .incl(new Tweet("s", "wewerwe", 101))
      .incl(new Tweet("tom", "a", 72))
      .incl(new Tweet("zyg", "a", 72))
      .incl(new Tweet("qwe", "df", 344))
      .incl(new Tweet("34", "f", 6))*/

  test("descending: set7") {
    new TestSets {
      var l = set7.descendingByRetweet
      assert(l.head.retweets === 344)
      l = l.tail
      assert(l.head.retweets === 101)
      l = l.tail
      assert(l.head.retweets === 72)
      l = l.tail
      assert(l.head.retweets === 72)
      l = l.tail
      assert(l.head.retweets === 6)
    }
  }
}
