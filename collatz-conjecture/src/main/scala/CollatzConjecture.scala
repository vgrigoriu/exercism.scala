import scala.annotation.tailrec

object CollatzConjecture {
  def steps(n: Int): Option[Int] = stepsRec(n, 0)

  @tailrec
  private def stepsRec(n: Int, acc: Int): Option[Int] = n match {
    case 1               => Some(acc)
    case _ if n < 1      => None
    case _ if n % 2 == 0 => stepsRec(n / 2, acc + 1)
    case _ if n % 2 != 0 => stepsRec(3 * n + 1, acc + 1)
  }
}
