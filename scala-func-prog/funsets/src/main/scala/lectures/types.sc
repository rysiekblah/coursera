type Set = Int => Boolean
def contains(s: Set, elem: Int): Boolean = s(elem)

contains(x => false, 100)

val gtz: Int => Boolean = x => x>0
gtz(2)
gtz(-1)

val vset: Set = s => s == 9
vset(2)
vset(9)

def singletonSet(elem: Int): Set = s => s == elem
val s1 = singletonSet(1)
val s1a = singletonSet(1)
val s2 = singletonSet(2)
val s3 = singletonSet(3)
val s4 = singletonSet(4)

def union(s: Set, t: Set): Set = in => s(in) || t(in)

val sbig1 = union(s1, s2)
val sbig2 = union(s1, s3)


def intersect(s: Set, t: Set): Set = in => s(in) && t(in)
val sint = intersect(sbig1, sbig2)
sint(1)
sint(2)
sint(3)

def diff(s: Set, t: Set): Set = in => s(in) && !t(in)
val sdiff = diff(sbig1, sbig2)
sdiff(2)
sdiff(1)
sdiff(3)
