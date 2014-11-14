object nqueens {
  def queens(n: Int): Set[List[Int]] = {

    def placeQueen(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueen(k-1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    placeQueen(n)
  }
  def isSafe(c: Int, q: List[Int]): Boolean = true
}