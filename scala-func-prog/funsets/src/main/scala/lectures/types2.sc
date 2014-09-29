type Pair = (Int, Int) => (Int, Int)
type PairOp = (Int, Int) => (Int, Int)

def pair(x: Int, y: Int) = (x,y)
pair(1,2)

val incPair: PairOp = (x,y) => pair(x+1, y+1)

incPair(1,2)
