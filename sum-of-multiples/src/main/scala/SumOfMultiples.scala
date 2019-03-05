object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    def isMultiple(x: Int) = factors.exists(x % _ == 0)

    val multiples = for (x <- 1 until limit; if isMultiple(x)) yield x

    multiples.sum
  }
}
