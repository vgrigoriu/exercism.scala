object Hamming {
  def distance(first: String, second: String): Option[Int] =
    if (first.length != second.length) {
      None
    } else {
      Some(first zip second count { pair =>
        pair._1 != pair._2
      })
    }
}
