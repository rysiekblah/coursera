type Set = Int => Boolean
def contains(s: Set, elem: Int): Boolean = s(elem)
def singletonSet(elem: Int): Set = s => s == elem
val s1 = singletonSet(2)
val s2 = singletonSet(4)
val s3 = singletonSet(8)
val s4 = singletonSet(10)
def union(s: Set, t: Set): Set = in => s(in) || t(in)
val sbig1 = union(s1, s2)
val sbig2 = union(s1, s3)
val sbig = union(union(s1,s2), union(s3, s4))
def intersect(s: Set, t: Set): Set = in => s(in) && t(in)
val sint = intersect(sbig1, sbig2)
def diff(s: Set, t: Set): Set = in => s(in) && !t(in)
val sdiff = diff(sbig1, sbig2)

def filter(s: Set, p: Int => Boolean): Set = x => p(x) && s(x)
val s = filter(sbig, x => x<2)

def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (!p(a) && s(a)) false
    else if (a==1000) true
    else iter(a+1)
  }
  iter(-1000)
}
forall(sbig, x => x%4 == 0)

def exists(s: Set, p: Int => Boolean): Boolean = forall(s, p)

exists(sbig, x => x % 4 == 0)

