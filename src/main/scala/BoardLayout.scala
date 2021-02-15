trait Grid {
  val rows: Array[Char]
  val columns: Array[Int]
}

object Chessboard extends Grid {
  val rows: Array[Char] = ('A' to 'H').toArray
  val columns: Array[Int] = (1 to 8).toArray
}
