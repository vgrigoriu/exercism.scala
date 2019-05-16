class Matrix(rows: Vector[Vector[Int]]) {
  def row(rowNo: Int): Vector[Int] =
    rows(rowNo)

  def column(columnNo: Int): Vector[Int] =
    for {
      row <- rows
    } yield row(columnNo)
}

object Matrix {
  def apply(input: String): Matrix = {
    val rows = for {
      line <- input.split("\n").toVector
    } yield parse(line)

    new Matrix(rows)
  }

  private def parse(line: String): Vector[Int] =
    for {
      n <- line.split(" ").toVector
    } yield n.toInt
}
