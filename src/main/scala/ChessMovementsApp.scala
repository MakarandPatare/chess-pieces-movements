import ChessPieces._

object ChessMovementsApp extends App {

  case class Position(file: Char, rank: Int) {
    override def toString: String = s"$file$rank"
  }

  case class Piece(name: String, position: Position)

  implicit def stringToPosition(posStr: List[String]): Position = {
    Position(posStr.head.charAt(0), posStr.tail.head.toInt)
  }

  def parseInput(input: String): Piece = {
    input.split(" ") match {
      case Array(name, pos) => Piece(name, pos.sliding(1).toList)
      case _ => Piece("", Position(' ', 0))
    }
  }

  def output(inputString: String): String = {
    val input = parseInput(inputString)
    if (!Chessboard.file.contains(input.position.file) || !Chessboard.rank.contains(input.position.rank))
      "Invalid input: Please check the file and rank"
    else input.name match {
      case Pawn.name => Pawn.possibleMoves(input.position)
      case King.name => King.possibleMoves(input.position)
      case Queen.name => Queen.possibleMoves(input.position)
      case Rook.name => Rook.possibleMoves(input.position)
      case Bishop.name => Bishop.possibleMoves(input.position)
      case Horse.name => Horse.possibleMoves(input.position)
      case _ => "Invalid input: Please check the piece name"
    }
  }

  /**
   * Please pass your inputs here for testing and trial
   */
  println(output("King D5"))
  println(output("Queen G9"))
}
