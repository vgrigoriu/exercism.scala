import scala.collection.immutable.TreeMap

class School {
  type DB = Map[Int, Seq[String]]

  private var grades: DB = TreeMap()

  def add(name: String, g: Int): Unit =
    grades = grades + (g -> (grades.getOrElse(g, Seq()) :+ name))

  def db: DB = grades

  def grade(g: Int): Seq[String] =
    grades.getOrElse(g, Seq())

  def sorted: DB =
    grades.mapValues(students => students.sorted)
}
