import ChessMovementsApp.parseInput
import ChessPieces.{KingMoves, Pawn}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ChessPiecesTest extends AnyFunSuite with Matchers {

  test("Pawn Moves") {
    val input = parseInput("Pawn D5")
    val moves = Pawn.possibleMoves(input._2)
    val expectedPositions = "E5"
    moves shouldBe expectedPositions
  }

  test("King Moves") {
    val input = parseInput("King D5")
    val moves = KingMoves.possibleMoves(input._2)
    val expectedPositions = "E5,E6,D6,C6,C5,C4,D4,E4"
    moves shouldBe expectedPositions
  }

}

