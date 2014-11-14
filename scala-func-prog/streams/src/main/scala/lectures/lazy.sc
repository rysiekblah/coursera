lazy val s = {print("S"); 2}
val d= {print("D"); 2}
s+d


def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
 }
 expr