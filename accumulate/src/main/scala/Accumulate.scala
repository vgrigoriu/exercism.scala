class Accumulate {
  def accumulate[A, B](f: A => B, list: List[A]): List[B] =
    map(f, list, List())

  def map[A, B](f: A => B, input: List[A], acc: List[B]): List[B] =
    input match {
      case Nil          => acc
      case head :: tail => map(f, tail, acc :+ f(head))
    }
}
