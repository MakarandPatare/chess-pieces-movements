object ChessPieces {
  case object Pawn extends SingleStep with PawnMoveDirs
  case object KingMoves extends SingleStep with KingMoveDirs
}
