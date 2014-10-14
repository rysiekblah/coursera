import utils._

def assertAllPos[S <: IntSet](r: S): S = r

def assertUpper[S <: Normal](c: S): S = c
assertUpper(new Sedan)
assertUpper(new VW)
//assertUpper(new Car) <-- out of bound

def assertLower[S >: Sedan](c: S): S = c
assertLower(new Normal)
assertLower(new Car)
assertLower(new Truck)


def assertMixed[S >: Sedan <: Normal](c: S): S = c
assertMixed(new VW)
