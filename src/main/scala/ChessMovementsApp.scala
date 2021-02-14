object ChessMovementsApp extends App {

  case class Position(file: Char, rank: Int) {
    override def toString: String = s"$file$rank"
  }

  implicit def stringToPosition(posStr: List[String]): Position = {
    Position(posStr.head.charAt(0), posStr.tail.head.toInt)
  }

  def parseInput(input: String): (String, Position) = {
    input.split(" ") match {
      case Array(piece, pos) => (piece, pos.sliding(1).toList)
      case _ => ("", Position(' ', 0))
    }
  }

  val input = parseInput("Pawn D5")
}
