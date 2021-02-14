object ChessPieces {
  trait ChessPiece {
    val name: String = this.toString
  }
  case object Pawn extends ChessPiece with SingleStep with PawnMoveDirs
  case object King extends ChessPiece with SingleStep with KingMoveDirs
  case object Queen extends ChessPiece with MultipleSteps with QueenMoveDirs
  case object Rook extends ChessPiece with MultipleSteps with RookMoveDirs
  case object Bishop extends ChessPiece with MultipleSteps with BishopMoveDirs
  case object Horse extends ChessPiece with SingleStep with HorseMoveDirs
}
