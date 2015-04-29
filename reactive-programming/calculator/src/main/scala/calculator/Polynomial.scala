package calculator

object Polynomial {
  // delta = b*b - 4*a*c
  def computeDelta(a: Signal[Double], b: Signal[Double], c: Signal[Double]): Signal[Double] =
    Signal {
      val bb = b()
      bb*b() - 4*a()*c()
    }

  // roots = (-b +/- sqrt(delta))/2*a
  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    Signal {
      if (delta() < 0) Set()
      else
        Set[Double]((-b() + math.sqrt(delta())) / (2 * a()), (-b() - math.sqrt(delta())) / (2 * a()))
    }
  }
}
