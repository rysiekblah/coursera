val fruits = "apple" :: "banana" :: Nil

fruits.isEmpty

def printList(list: List[String]): List[String] = list match {
  case Nil => {
    println("End")
    List()
  }
  case List() => {
    println("EmptyList")
    List()
  }
  case x :: xs => {
    println("Element: " + x)
    printList(xs)
  }
}
printList(fruits)
printList(List())
fruits map ("Fruit: " + _)
List.range(1, 5)
List.range(1, 5) flatMap (i => List.range(1,i))
List.range(1, 5) map (i => List.range(1, i))
List.range(1, 5) flatMap (i=> List.range(1, i))
//List.range(1, 5) flatMap ()