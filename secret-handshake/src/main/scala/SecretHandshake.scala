import scala.collection.mutable.ListBuffer

object SecretHandshake {
  def commands(n: Int): List[String] = {
    var list = ListBuffer[String]()
    if ((n & 1) != 0) {
      list.append("wink")
    }
    if ((n & 2) != 0) {
      list.append("double blink")
    }
    if ((n & 4) != 0) {
      list.append("close your eyes")
    }
    if ((n & 8) != 0) {
      list.append("jump")
    }
    if ((n & 16) != 0) {
      list = list.reverse
    }
    list.toList
  }
}
