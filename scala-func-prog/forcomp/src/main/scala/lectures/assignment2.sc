import java.io.File

case class Person(name: String, isMale: Boolean, children: Person*)
val lara = Person("Lara", false)
val bob = Person("Bob", true)
val julie = Person("Julie", false, lara, bob)
val persons = List(lara, bob, julie)

persons.filter(p => !p.isMale).flatMap(p=>p.children.map(c=>(p.name, c.name)))
persons.withFilter(p => !p.isMale).flatMap(p=>p.children.map(c=> c.name))
for(p <- persons if !p.isMale; c <- p.children) yield (p.name, c.name)

val files = new File("IdeaProjects").listFiles()
files.array.head.getAbsolutePath
for(file <- files if file.getName.startsWith("coursera")) println(file)


def coursera =
  for{file <- files if file.getName.startsWith("coursera")} yield file

type Occurrences = List[(Char, Int)]
val pairs = List(('a', 2), ('b', 2))
def combinations(occurrences: Occurrences): List[Occurrences] =
  Nil :: (for { (chr, cnt) <- occurrences;
    count <- 1 to cnt
    tail <- combinations(occurrences.filter(item => item._1 > chr))
  } yield List((chr, count)) ++ tail)

combinations(pairs)
