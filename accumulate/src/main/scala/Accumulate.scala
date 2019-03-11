class Accumulate {
  def accumulate[A, B](f: A => B, list: List[A]): List[B] =
    list.foldRight(List[B]()) { (item, result) =>
      f(item) :: result
    }
}
