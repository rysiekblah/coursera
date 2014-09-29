type Set = Int => Boolean
def contains(s: Set, elem: Int): Boolean = s(elem)

contains(x => false, 100)

val gtz: Int => Boolean = x => x>0
gtz(2)
gtz(-1)

val vset: Set = s => s == 9

