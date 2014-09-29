def sumInts(a: Int, b: Int): Int = if(a>b) 0 else a + sumInts(a+1, b)
sumInts(1,4)

def cube(x: Int): Int = x*x*x

def sum(f: (Int) => Int, a: Int, b: Int): Int =
  if(a>b) 0 else f(a) + sum(f, a+1, b)

def sumCubes(a: Int, b: Int) = sum(cube, a, b)

sumCubes(1, 4)

def eqInt = (x: Int, y: Int) => x == y
eqInt(1,1)

type Pair = (Int, Int) => Boolean
val eqPairVal: Pair = (x,y) => x==y
eqPairVal(1,2)
eqPairVal(2,2)

