import scala.io.Source

val in =
  Source.fromURL(
    "http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

val words = in.getLines().toList.filter(wr => wr forall(ch => ch.isLetter))
val mnemonics = Map(
  '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

val charCode: Map[Char, Char] =
  for((digit, str) <- mnemonics; ltr <- str) yield ltr -> digit

def wordCode(word: String): String =
  word.toUpperCase map charCode
  //(for(sign <- word) yield charCode.get(sign.toUpper)).mkString

val wordsForNum: Map[String, Seq[String]] =
  words groupBy wordCode withDefaultValue Seq()

def encode(number: String): Set[List[String]] =
  if(number.isEmpty) Set(List())
  else {
    for {
      split <- 1 to number.length
      word <- wordsForNum(number take split)
      rest <- encode(number drop split)
    } yield word :: rest
  }.toSet