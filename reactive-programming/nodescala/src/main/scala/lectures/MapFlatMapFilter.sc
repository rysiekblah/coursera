val l = List(1, 2, 3, 4, 5)
val ll = List(List(1,2,3), List(5,5,5,5), List(0))

// incrementator
l map (_ + 1)

//
ll flatMap (_.toList)
ll map (_.toList)

// heads
ll flatMap (f => List(f.head))
ll map (f => List(f.head))

// items with size of every item
ll flatMap (f => List(f.size))
ll map (f => List(f.size))

// creates list with sum of every item (List)
ll flatMap(f=>List(f.sum))
