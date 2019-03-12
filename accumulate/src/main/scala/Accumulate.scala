import scala.collection.mutable.ListBuffer

class Accumulate {
  def accumulate[A, B](f: A => B, list: List[A]): List[B] =
    map(f, list, ListBuffer()).toList

  def map[A, B](f: A => B, input: List[A], acc: ListBuffer[B]): ListBuffer[B] =
    input match {
      case Nil          => acc
      case head :: tail => map(f, tail, acc :+ f(head))
    }
}
