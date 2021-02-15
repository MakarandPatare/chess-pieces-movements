trait Grid {
  val rows: Array[Char]
  val columns: Array[Int]
}

object Chessboard extends Grid {
  val rows = ('A' to 'H').toArray
  val columns = (1 to 8).toArray
}
