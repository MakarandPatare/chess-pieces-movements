object ChessPieces {
  case object Pawn extends SingleStep with PawnMoveDirs
  case object King extends SingleStep with KingMoveDirs
  case object Queen extends MultipleSteps with QueenMoveDirs
  case object Rook extends MultipleSteps with RookMoveDirs
  case object Bishop extends MultipleSteps with BishopMoveDirs
}
