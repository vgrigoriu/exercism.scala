case class Robot(bearing: Bearing.Val, coordinates: (Int, Int)) {
  def turnRight: Robot = Robot(bearing.turnRight, coordinates)
  def turnLeft: Robot = Robot(bearing.turnLeft, coordinates)
  def advance: Robot = coordinates match {
    case (x, y) => Robot(bearing, (x + bearing.dx, y + bearing.dy))
  }
  def simulate(instructions: String): Robot = instructions.foldLeft(this) {
    (acc, i) => i match {
      case 'L' => acc.turnLeft
      case 'R' => acc.turnRight
      case 'A' => acc.advance
    }
  }
}

object Bearing extends Enumeration {
  case class Val(dx: Int, dy: Int) extends super.Val {
    def turnRight: Bearing.Val = this match {
      case North => East
      case East  => South
      case South => West
      case West  => North
    }
    def turnLeft: Bearing.Val = this match {
      case North => West
      case West  => South
      case South => East
      case East  => North
    }
  }

  val North = Val(0, 1)
  val East  = Val(1, 0)
  val South = Val(0, -1)
  val West  = Val(-1, 0)
}
