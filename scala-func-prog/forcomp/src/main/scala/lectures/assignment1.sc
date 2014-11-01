val list = List("Every", "student", "likes", "Scala").
  groupBy((element: String) => element.length)
list.toList

val str = "tomekkozlowski"
val m = str.toCharArray.groupBy(w => w).mapValues(_.size)
m.toList.sorted

val l = List("ate", "eat", "cc", "dd", "ee")
l.mkString

//val words = List("one", "two", "one", "three", "four", "two", "one")
//val counts = words.groupBy(w => w).mapValues(_.size)
//counts.toList
type Occurrences = List[(Char, Int)]
type Word = String
type Sentence = List[Word]
def wordOccurrences(w: Word): Occurrences = w.toLowerCase.toCharArray.groupBy(w => w).mapValues(_.size).toList.sorted
def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences(s.mkString)
val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
  l.groupBy(w => wordOccurrences(w))
