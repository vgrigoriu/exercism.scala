import scala.collection.mutable

object BookStore {
  private val cache = mutable.Map[List[Int], Int]()

  private val discount =
    Map(0 -> 100, 1 -> 100, 2 -> 95, 3 -> 90, 4 -> 80, 5 -> 75)

  def total(books: List[Int]): Int =
    cache.getOrElseUpdate(books, getTotal(books))

  private def getTotal(books: List[Int]): Int = books match {
    case List() => 0
    case _ =>
      books.toSet.subsets
        .filter(_.nonEmpty)
        .map(group => price(group) + total(books diff group.toList))
        .min
  }

  private def price(group: Set[Int]): Int =
    8 * group.size * discount(group.size)
}
