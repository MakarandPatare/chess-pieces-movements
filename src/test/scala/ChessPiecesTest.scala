import ChessMovementsApp.parseInput
import ChessPieces.Pawn
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ChessPiecesTest extends AnyFunSuite with Matchers {
  test("Pawn Moves") {
    val input = parseInput("Pawn D5")
    val moves = Pawn.possibleMoves(input._2)
    val expectedPositions = "E5"
    moves shouldBe expectedPositions
  }

}

