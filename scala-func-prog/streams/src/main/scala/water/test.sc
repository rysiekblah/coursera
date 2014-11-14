import water.Pouring

val problem = new Pouring(Vector(4,7))
problem.moves

problem.pathSets.take(3).toList

def gt(a: Int): Int => Boolean = {
  n:Int => n>a
}

val gtzero = gt(0)
gtzero(4)
gtzero(-1)


val v: Vector[Vector[Char]] = Vector(Vector('1','2'),Vector('3','4'))
v.take(1).head
val ch = v.take(1).head.take(1).head
print(ch)
if (ch == '1') true
else false


