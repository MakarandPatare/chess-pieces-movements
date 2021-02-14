import Directions._

sealed trait Direction {
  val shift : (Int, Int)
}

/**
 * Possible move directions for chess pieces excluding Horse
 */
object Directions {
  case object F  extends Direction { val shift = (1, 0) }  // Forward
  case object FR extends Direction { val shift = (1, 1) }  // Forward-Right
  case object R  extends Direction { val shift = (0, 1) }  // Right
  case object BR extends Direction { val shift = (-1, 1) } // Backward-Right
  case object B  extends Direction { val shift = (-1, 0) } // Backward
  case object BL extends Direction { val shift = (-1, -1) }// Backward-Left
  case object L  extends Direction { val shift = (0, -1) } // Left
  case object FL extends Direction { val shift = (1, -1) } // Forward-Left

  val allButHorse = List[Direction](F, FR, R, BR, B, BL, L, FL)
}

/**
 * Possible move directions for Horse
 */
object HorseDirections {
  case object HFR extends Direction { val shift = (2, 1) } // 2 Forward 1 Right
  case object HRF extends Direction { val shift = (1, 1) } // 2 Right 1 Forward
  case object HBR extends Direction { val shift = (-2, 1) } // 2 Backward 1 Right
  case object HRB extends Direction { val shift = (-1, 2) } // 2 Right 1 Backward
  case object HBL extends Direction { val shift = (-2, -1) } // 2 Backward 1 Left
  case object HLB extends Direction { val shift = (-1, -2) } // 2 Left 1 Backward
  case object HFL extends Direction { val shift = (2, -1) } // 2 Forward 1 Left
  case object HLF extends Direction { val shift = (-1, 2) } // 2 Left 1 Forward

  val allHorseDirections = List[Direction](HFR, HRF, HBR, HRB, HBL, HLB, HFL, HLF)
}

trait PawnMoveDirs extends Move {
  def directions = List(F)
}

trait KingMoveDirs extends Move {
  def directions = Directions.allButHorse
}

trait QueenMoveDirs extends Move {
  override def directions: List[Direction] = Directions.allButHorse
}

trait RookMoveDirs extends Move {
  override def directions: List[Direction] = List(F, R, B, L)
}

trait BishopMoveDirs extends Move {
  override def directions: List[Direction] = List(FR, BR, BL, FL)
}

