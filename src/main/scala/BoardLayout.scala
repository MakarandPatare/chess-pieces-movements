trait Grid {
  val file: Array[Char]
  val rank: Array[Int]
}

object Chessboard extends Grid {
  val file = ('A' to 'H').toArray
  val rank = (1 to 8).toArray
}
