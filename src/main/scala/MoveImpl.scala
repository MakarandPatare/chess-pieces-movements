import ChessMovementsApp.Position
import Directions.F

trait Move {
  implicit def int2Char(x : Int) : Char = x.toChar
  import Chessboard._
  def maxSteps: Int
  def directions: List[Direction]
  def moves(pos: Position, dir: Direction, remSteps: Int, posList: List[Position]): List[Position] = {
    if (pos.file <= file.head || pos.file >= file.last || pos.rank <= rank.head || pos.rank >= rank.last || remSteps == 0)
      posList
    else {
      val appendedPosList = posList :+ Position(pos.file + dir.shift._1, pos.rank + dir.shift._2)
      moves(Position(pos.file + dir.shift._1, pos.rank + dir.shift._2), dir, remSteps - 1, appendedPosList)
    }
  }
  def possibleMoves(pos: Position): String = {
    directions.flatMap {
      dir => moves(pos, dir, maxSteps, List[Position]())
    }.mkString(",")
  }
}

trait SingleStep extends Move {
  override def maxSteps: Int = 1
}

trait PawnMoveDirs extends Move {
  def directions = List(F)
}

trait KingMoveDirs extends Move {
  def directions = Directions.allButHorse
}
