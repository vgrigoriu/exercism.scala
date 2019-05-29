sealed trait ListOrLists[+A]

case object LoLNil extends ListOrLists[Nothing] {}
case class LoLCons[A](head: A, tail: ListOrLists[A]) extends ListOrLists[A]
case class LoLConsList[A](head: ListOrLists[A], tail: ListOrLists[A]) extends ListOrLists[A]

object FlattenArray {
  def flatten(list: List[_]): List[Int] = innerFlatten(unsafeToLoLInt(list))

  private def innerFlatten[A](list: ListOrLists[A]): List[A] = {
    println(list)
    val result = list match {
      case LoLNil => List()
      case LoLCons(head, tail) => head :: innerFlatten(tail)
      case LoLConsList(head, tail) => innerFlatten(head) ++ innerFlatten(tail)
    }
    println(result)
    result
  }

  private def unsafeToLoLInt[A](list: List[_]): ListOrLists[Int] = list match {
    case Nil => LoLNil
    case (head: List[_]) :: tail => LoLConsList(unsafeToLoLInt(head), unsafeToLoLInt(tail))
    case (head: Int) :: tail => LoLCons(head, unsafeToLoLInt(tail))
    case null :: tail => unsafeToLoLInt(tail)
  }
}
