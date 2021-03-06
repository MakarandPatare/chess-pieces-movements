import ChessMovementsApp.Position

trait Move {
  implicit def int2Char(x : Int) : Char = x.toChar
  import Chessboard._
  def maxSteps: Int
  def directions: List[Direction]
  def moves(pos: Position, dir: Direction, remSteps: Int, posList: List[Position]): List[Position] = {
    if (pos.row < rows.head || pos.row > rows.last || pos.column < columns.head || pos.column > columns.last || remSteps == 0)
      posList
    else {
      val appendedPosList = posList :+ Position(pos.row + dir.shift._1, pos.column + dir.shift._2)
      moves(Position(pos.row + dir.shift._1, pos.column + dir.shift._2), dir, remSteps - 1, appendedPosList)
    }
  }
  def possibleMoves(pos: Position): String = {
    directions.flatMap {
      dir => moves(pos, dir, maxSteps, List[Position]())
    }.filter(p => Chessboard.rows.contains(p.row) && Chessboard.columns.contains(p.column)).mkString(",")
  }
}

trait SingleStep extends Move {
  override def maxSteps: Int = 1
}

trait MultipleSteps extends Move {
  override def maxSteps: Int = 8
}
