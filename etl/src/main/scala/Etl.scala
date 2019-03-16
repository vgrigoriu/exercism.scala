object Etl {
  def transform[A](scoresToLetter: Map[A, Seq[String]]): Map[String, A] =
    invert(scoresToLetter, (l: String) => l.toLowerCase)

  private def invert[A, B, C](oneToMany: Map[A, Seq[B]],
                              transformation: B => C): Map[C, A] =
    oneToMany.foldLeft(Map[C, A]()) { (cToA, keyToList) =>
      keyToList match {
        case (key, list) =>
          list.foldLeft(cToA) { (cToA, item) =>
            cToA + (transformation(item) -> key)
          }
      }
    }
}
