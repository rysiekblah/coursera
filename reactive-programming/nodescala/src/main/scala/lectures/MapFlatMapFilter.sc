val l = List(1, 2, 3, 4, 5)
val ll = List(List(1,2,3), List(5,5,5,5), List(0))

//l map (_ + 1)
//ll flatMap (_.toList)
//ll map (_.toList)
//
//ll flatMap (f => List(f.head))
//ll map (f => List(f.head))
//
//ll flatMap (f => List(f.size))
//ll map (f => List(f.size))

var sum = 0
l foreach(sum += _)