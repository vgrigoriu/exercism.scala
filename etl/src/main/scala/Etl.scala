object Etl {
  def transform[A](scoresToLetter: Map[A, Seq[String]]): Map[String, A] =
    invert(scoresToLetter, (l: String) => l.toLowerCase)

  private def invert[A, B, C](oneToMany: Map[A, Seq[B]],
                               transformation: B => C): Map[C, A] =
    for {
      (key, list) <- oneToMany
      item <- list
    } yield transformation(item) -> key
}
